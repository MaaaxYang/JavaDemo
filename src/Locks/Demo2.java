/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/3/16.
 */
public class Demo2 {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();

    public static int count = 0;
    public static int count2 = 0;

    public static void main(String[] args)throws  Exception{

        //lock.lock();
        for (;count<10;count++){
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Demo2 demo2 = new Demo2();
                    demo2.runA();
                }
            });
            thread1.start();
        }

        for (;count2<10;count2++){
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Demo2 demo2 = new Demo2();
                    demo2.runB();
                }
            });
            thread2.start();
        }




        //condition1.signalAll();
        System.out.println("over");
        //lock.unlock();

    }

    public void runA(){
        lock.lock();
        try{
            condition1.await();
            System.out.println("得到消息："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void runB(){

        try{
            LockSupport.parkNanos(1000*1000*1000*10);
            lock.lock();
            condition1.signal();
            System.out.println("唤醒其他线程："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public class RunClass implements Runnable{

        private int num;

        private Lock lock;

        public RunClass(int num, Lock lock) {
            this.num = num;
            this.lock = lock;
        }

        @Override
        public void run() {
            try{

            }catch (Exception e){

            }
        }
    }
}
