/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 大数据合并工具
 */
public class BigDataMergeTool {

    // 核心线程数
    private static final int poolCore = 2;

    // 最大线程数
    private static final int poolMax = 10;

    // 线程池
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            poolCore,
            poolMax,
            1000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10000),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    LockSupport.parkNanos(1000 * 1000 * 1000);
                    executor.execute(r);
                }
            }
    );

    // map文件映射
    private static ArrayList<FileMap> fileMaps = new ArrayList<>(16);

    private static ConcurrentHashMap<Integer,List<CacheHash>> dic = new ConcurrentHashMap<>(65535);

    private static ConcurrentHashMap<Integer,AtomicInteger> writeCountMap = new ConcurrentHashMap<>(65535);

    // 文件内容分割大小界限
    private static int[] bitSizeThresholds = {4096,4096<<1,4096<<2,4096<<3,4096<<4,4096<<5,4096<<6,4096<<7};

    // 加载文件
    private static final void loadFile(String filePath){
        File file = new File(filePath);
        if (!file.exists()){
            return;
        }
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String text = null;
            while ((text = bufferedReader.readLine())!=null){

                int hash = reHash(text.hashCode());
                int newSize = selectBitSize(text);
                byte[] newByte = text.getBytes();
                if (newSize>0){
                    newByte = Arrays.copyOf(text.getBytes(),newSize);
                }
                CacheHash cacheHash = new CacheHash(hash,newSize,newByte);

                if (dic.containsKey(hash)){
                    List<CacheHash> cacheHashList = dic.get(hash);
                    cacheHashList.add(cacheHash);
                }else{
                    List<CacheHash> list = new LinkedList<>();
                    list.add(cacheHash);
                    dic.put(hash,list);
                }

                // 分片写入文件
                if (dic.get(hash).size()>=1024){
                    synchronized (BigDataMergeTool.class){
                        int index = 0;
                        if (writeCountMap.containsKey(hash)){
                            index = writeCountMap.get(hash).incrementAndGet();
                        }else{
                            AtomicInteger atomicInteger = new AtomicInteger(0);
                            writeCountMap.put(hash,atomicInteger);
                        }
                        FileMap fileMap = new FileMap(hash,newSize,index,dic.get(hash));
                        // 先写入缓存，通过线程池异步写入磁盘
                        fileMaps.add(fileMap);
                        dic.put(hash,new LinkedList<>());
                    }
                }
            }


            //FileChannel fileChannel =  new RandomAccessFile(file,"r").getChannel();
            //fileInputStream = new FileInputStream(file);
            //fileChannel = fileInputStream.getChannel();
            //MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            byte[] data = new byte[(int) file.length()];

            //ByteBuffer byteBuffer = mappedByteBuffer.get(data);

            String str = new String(data);

            String[] strs = str.split("\r\n");

//            for (int i = 0; i < strs.length; i++) {
//                hashMap.put(strs[i], "");
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                fileChannel.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    // 使用内存映射读文件，每次读取4K倍数


    // 根据内容长度拆分为多个文件

    // 使用数组作为容器，hashcode+长度位

    // 读取各个子文件进行对比去重

    // 写入新文件


    private static int selectBitSize(String str){
        int bitSize = str.getBytes().length;
        for(int i = 0;i<bitSizeThresholds.length;i++){
            if (bitSize<bitSizeThresholds[i]){
                return bitSizeThresholds[i];
            }
        }
        return -1;
    }

    // 文件映射关系
    private static class FileMap{

        private int hash;

        private int bitSize;

        private int index;

        private List<CacheHash> list;

        public FileMap(int hash, int bitSize, int index, List<CacheHash> list) {
            this.hash = hash;
            this.bitSize = bitSize;
            this.index = index;
            this.list = list;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public int getBitSize() {
            return bitSize;
        }

        public void setBitSize(int bitSize) {
            this.bitSize = bitSize;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public List<CacheHash> getList() {
            return list;
        }

        public void setList(List<CacheHash> list) {
            this.list = list;
        }
    }

    // 缓存
    private static class CacheHash{
        private int hash;

        private int size;

        private byte[] bytes;

        public CacheHash(int hash, int size, byte[] bytes) {
            this.hash = hash;
            this.size = size;
            this.bytes = bytes;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public byte[] getBytes() {
            return bytes;
        }

        public void setBytes(byte[] bytes) {
            this.bytes = bytes;
        }
    }

    // 重新hash 限定hash范围
    private static int reHash(int hash){
        return hash & 65535;
    }
}
