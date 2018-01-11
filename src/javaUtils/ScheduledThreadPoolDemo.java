package javaUtils;

import java.util.Random;
import java.util.concurrent.*;

public class ScheduledThreadPoolDemo {
    public void run() throws Exception {
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<Integer> result=pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num=new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    return num;
                }

            }, 2, TimeUnit.SECONDS);//每次延迟两秒后运行
            System.out.println(result.get());
        }
        pool.shutdown();
    }
}
