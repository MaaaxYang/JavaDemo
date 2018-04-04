
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;


/**
 *     假设内存空间充足
 *     万亿级别的两个URL文件A和B，如何求出A和B的差集C
 *     1.内存映射读取大文件，多线程同时读取多个文件
 *     2.通过map的key不重复的特性去重
 *     3.提升写入效率 应考虑4K对齐
 *     3.拆分keySet
 *     4.多线程写入文件最终得到不重复的内容合集
 */
public class Demo {

    private static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>(4096);

    private static final int poolCore = 2;

    private static final int poolMax = 10;

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
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


    // 读文件
    public void funcRead(String filePath) {
        File file = new File(filePath);
        if (!file.exists()){
            return;
        }
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        try {
            fileInputStream = new FileInputStream(file);

            fileChannel = fileInputStream.getChannel();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
            byte[] data = new byte[(int) file.length()];

            // 可以分更小的块读取，但要处理 字符串不完整问题，可以更优化
            ByteBuffer byteBuffer = mappedByteBuffer.get(data);

            String str = new String(data);

            String[] strs = str.split("\r\n");

            for (int i = 0; i < strs.length; i++) {
                hashMap.put(strs[i], "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 多线程写文件
    public void funcWrite(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // set 分割
        LinkedList<Spliterator<String>> spliterators = new LinkedList<>();
        Spliterator<String> sourceSpliter = hashMap.keySet().spliterator();

        spliterators.add(sourceSpliter);
        for (int i = 1; i < poolMax; i++) {
            Spliterator<String> temp = sourceSpliter.trySplit();
            if (temp != null) {
                spliterators.add(temp);
            } else {
                break;
            }
        }

        CountDownLatch countDownLatch = new CountDownLatch(spliterators.size());

        for (Spliterator<String> spl : spliterators) {
            // 多个线程同时写
            threadPoolExecutor.execute(new WriteRunable(spl, file, countDownLatch));
        }

        countDownLatch.await();

        System.out.println("写入完毕");
    }


    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();

        CountDownLatch countDownLatch = new CountDownLatch(2);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                demo.funcRead("G:/test.txt");
                countDownLatch.countDown();
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                demo.funcRead("G:/test2.txt");
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();


        demo.funcWrite("G:/test3.txt");

        threadPoolExecutor.shutdown();
        System.out.println("end");
    }

    public static class WriteRunable implements Runnable {

        private Spliterator<String> spliterator;

        private File file;

        private CountDownLatch countDownLatch;

        public WriteRunable(Spliterator<String> spliterator, File file, CountDownLatch countDownLatch) {
            this.spliterator = spliterator;
            this.file = file;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);

                FileChannel fileChannel = fileOutputStream.getChannel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024 * 256);
                spliterator.forEachRemaining(entry -> {
                    try {
                        byteBuffer.put((entry + "\r\n").getBytes());

                        if (byteBuffer.position() >= 1024 * 1024 * 255) {

                            byteBuffer.flip();

                            while (byteBuffer.hasRemaining()) {

                                fileChannel.write(byteBuffer);
                            }
                            byteBuffer.clear();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                if (byteBuffer.position() > 1) {

                    byteBuffer.flip();

                    while (byteBuffer.hasRemaining()) {

                        fileChannel.write(byteBuffer);
                    }
                    byteBuffer.clear();
                }

                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }
    }

}
