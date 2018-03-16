/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/3/8.
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception{

        Date now = new Date();
        Thread.sleep(1000);
        Date after = new Date();
        System.out.println(now.before(after));


        LinkedHashMap<String,Object> map = new LinkedHashMap(16,0.75f,true);
        map.put("",null);
        map.put(null,null);

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,new Object());
        //demo4();

    }



    public class FX<T>{
        public void run(){
            System.out.println("run FX");
        }
    }

    public class FXA extends FX{
        @Override
        public void run(){
            System.out.println("run FXA");
        }
    }

    public class FXB  extends FX{
        @Override
        public void run(){
            System.out.println("run FXB");
        }
    }

    public static void demo5(){
        try{
            ReentrantLock lock = new ReentrantLock();
            System.out.println("start");
            lock.lock();
            lock.unlock();

            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void demo4(){
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try{
            countDownLatch.countDown();
            System.out.println("start");
            countDownLatch.await();
            System.out.println("end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void demo3(){
        int a=1,b = 1;
        int c = 0;
        System.out.print(a+" "+b+" ");
        while (true){
            c = a+b;
            a = b;
            b = c;
            System.out.print(c+" ");
            if (c>100){
                return;
            }
        }
    }

    public static void demo2(){
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                6,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10000),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("线程池队列已满");
                    }
                }
        );

//        executorService.execute(()->{
//            System.out.println("测试数据-"+Thread.currentThread().getName());
//            try {
//                Thread.sleep(10);
//            }catch (Exception ex){
//                ex.printStackTrace();
//            }
//        });
        for(int i = 0;i<1;i++){
            executorService.execute(()->{
                System.out.println("测试数据-"+Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        }



    }

    public void demo1(){
        try{
            Thread thread = new Thread();
            thread.setName("my-thread");
            thread.start();
            thread.interrupt();
            while (true){
                boolean isActive = thread.isAlive();
                System.out.println("isActive - "+isActive);
                boolean isInterrupted = thread.isInterrupted();
                isActive = thread.isAlive();
                System.out.println("isInterrupted - "+isInterrupted);
                System.out.println("isActive - "+isActive);
                System.out.println("================================");
                Thread.sleep(1000);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
