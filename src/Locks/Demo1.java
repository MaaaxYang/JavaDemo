/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/3/16.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{
        Demo1 demo1 = new Demo1();
        demo1.lockRun();
        System.out.println("end");
    }

    public int state = 1;

    public void lockRun() throws Exception{

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    for (int i = 0;i<10;i++){
                        lock.lock();
                        while (state!=1){
                            condition1.await();
                        }
                        System.out.print("1 ");
                        state = 2;
                        condition2.signalAll();
                        lock.unlock();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(()->{
            try{
                for (int i = 0;i<10;i++){
                    lock.lock();
                    while (state!=2){
                        condition2.await();
                    }
                    System.out.print("2 ");
                    state = 3;
                    condition3.signalAll();
                    lock.unlock();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try{
                for (int i = 0;i<10;i++){
                    lock.lock();
                    while (state!=3){
                        condition3.await();
                    }
                    System.out.print("3 ");
                    System.out.println();
                    state = 1;
                    condition1.signalAll();
                    lock.unlock();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();


    }
}
