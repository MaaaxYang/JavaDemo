package javaUtils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public void run() {
        ReadWriteLockClass rw=new ReadWriteLockClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int)(Math.random()*101));
            }
        },"Write").start();

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }

    class ReadWriteLockClass{
        private int number=0;
        private ReadWriteLock lock=new ReentrantReadWriteLock();

        //读
        public void get(){
            lock.readLock().lock();//上锁
            try{
                System.out.println(Thread.currentThread().getName()+" : "+number);
            }finally{
                lock.readLock().unlock();//释放锁
            }
        }

        //写
        public void set(int number){
            lock.writeLock().lock();
            try{
                System.out.println(Thread.currentThread().getName());
                this.number=number;
            }finally{
                lock.writeLock().unlock();
            }
        }
    }
}
