/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RequestCount {

    /**
    评测题目: url访问量统计
    网站的访问日志大概是这样的
    2017-7-19+11:10:22+-+11.232.12.3
    2017-7-19+11:10:22+-+11.232.11.3
    ...
    2017-7-29+23:11:22+-+11.15.11.10
    日志文件的大小约为10g,机器内存的大小约为1g。
    要求写一个程序统计访问量前10的ip地址。
    */

    /**
     * 文件拆分成多分每份256M（10g / 10 / 2 / 2）
     * 切割字符串map映射ip,count
     * 生成map映射文件
     *
     */

    public static int fileIndex = 0;

    public static TreeSet<IpNode> tree = new TreeSet<>(new Comparator<IpNode>() {
        @Override
        public int compare(IpNode o1, IpNode o2) {
            if (o1.count.intValue()<o2.count.intValue()){
                return -1;
            }else if(o1.count.intValue()>o2.count.intValue()){
                return 1;
            }else{
                return 0;
            }
        }
    });

    public static void statistics(String filePath) throws Exception{
        // 先不考虑性能、不考虑内存、先实现基本功能
        File file = new File(filePath);
        if (!file.exists()){
            return;
        }

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lineText = "";
        while ((lineText = bufferedReader.readLine())!=null){
           String ip = lineText.split("/+/-/+")[1];
           IpNode node = new IpNode(ip,0);
           if (tree.contains(node)){
               node.count+=1;
           }else {
               tree.add(node);
           }

           if (tree.size()>128){
               // map映射写入磁盘文件
               writeFile(filePath,fileIndex++);
               tree = new TreeSet<>();
           }
        }
        if (tree.size()>0){
            writeFile(filePath,fileIndex++);
            tree = new TreeSet<>();
        }
        bufferedReader.close();
        inputStreamReader.close();

        // 遍历读取磁盘分割文件
        readFile(filePath);

        // 输出 tree 中的结果
        print();

    }

    public static void print(){
        for(IpNode node:tree){
            System.out.println("ip:" + node.ip + " count:"+node.count);
        }
    }

    public static void writeFile(String filePath,int offset) throws Exception{
        int index = filePath.lastIndexOf(".log");
        Path path = Paths.get(filePath.substring(0,index)+"_"+offset+".log");
        StringBuilder fommat = new StringBuilder();
        for(IpNode node : tree){
            fommat.append(node.toString());
        }
        Files.write(path,fommat.toString().getBytes(),null);
    }

    public static void readFile(String filePath) throws Exception{
        for(int i = 0;i<fileIndex;i++){
            readFile(filePath,i);
        }
    }

    public static int readFile(String filePath,int offset) throws Exception{
        int index = filePath.lastIndexOf(".log");
        Path path = Paths.get(filePath.substring(0,index)+"_"+offset+".log");

        File file = new File(filePath);
        if (!file.exists()){
            return -1;
        }

        int lineCount = 0;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lineText = "";
        while ((lineText = bufferedReader.readLine())!=null){
            if (lineCount>10){
                return 1;
            }
            String[] temp = lineText.split("-");
            IpNode newNode = new IpNode(temp[0],Integer.parseInt(temp[1]));
            if (tree.contains(newNode)){
                // 获取节点 + 新值
                for(IpNode node:tree){
                    if (node.equals(newNode)){
                        node.count+=newNode.count;
                    }
                }
            }else {
                tree.add(newNode);
            }
            lineCount++;
        }
        bufferedReader.close();
        inputStreamReader.close();
        return 1;
    }

    public static class IpNode{
        public String ip;
        public Integer count;

        @Override
        public String toString() {
            return ip +"_" +count.intValue();
        }

        @Override
        public int hashCode(){
            return ip.hashCode();
        }

        @Override
        public boolean equals(Object object) {
            return ip.equals(object);
        }

        public IpNode(String ip, Integer count) {
            this.ip = ip;
            this.count = count;
        }
    }
}
