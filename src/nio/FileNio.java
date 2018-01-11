package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileNio {
    public static void run()
    {
        test1();
    }

    //利用通道完成文件的复制(非直接缓冲区)
    public static void test1(){
        long start=System.currentTimeMillis();

        FileInputStream fis=null;
        FileOutputStream fos=null;

        FileChannel inChannel=null;
        FileChannel outChannel=null;
        try{
            fis=new FileInputStream("D:\\CodeDemo\\project.json");
            fos=new FileOutputStream("D:\\CodeDemo\\project2.json");

            //1.获取通道
            inChannel=fis.getChannel();
            outChannel=fos.getChannel();

            //2.分配指定大小的缓冲区
            ByteBuffer buf=ByteBuffer.allocate(1024);

            //3.将通道中的数据存入缓冲区中
            while(inChannel.read(buf)!=-1){
                buf.flip();//切换读取数据的模式
                //4.将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear();//清空缓冲区
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));//耗费时间：1094
    }

    //使用直接缓冲区完成文件的复制(内存映射文件)
    public static void test2() {
        long start=System.currentTimeMillis();

        FileChannel inChannel=null;
        FileChannel outChannel=null;
        try {
            inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
            outChannel= FileChannel.open(Paths.get("d:/2.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuf= inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf=outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            //直接对缓冲区进行数据的读写操作
            byte[] dst=new byte[inMappedBuf.limit()];

            inMappedBuf.get(dst);
            outMappedBuf.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end=System.currentTimeMillis();
        System.out.println("耗费的时间为："+(end-start));//耗费的时间为：200
    }


    //通道之间的数据传输(直接缓冲区)
    public static void test3(){
        long start=System.currentTimeMillis();

        FileChannel inChannel=null;
        FileChannel outChannel=null;
        try {
            inChannel = FileChannel.open(Paths.get("d:/1.avi"), StandardOpenOption.READ);
            outChannel=FileChannel.open(Paths.get("d:/2.avi"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费的时间为："+(end-start));//耗费的时间为：147
    }
}
