package javaUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public void run() {

        CountDownLatch countDownLatch = new CountDownLatch(100);

        Ticket ticket=new Ticket(countDownLatch);
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();

        try{
            countDownLatch.await();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("票买完了....");
    }

    class Ticket implements Runnable{
        private int tick=100;
        private Lock lock=new ReentrantLock();

        private CountDownLatch countDownLatch;

        public Ticket(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            while(true){
                lock.lock();
                try{
                    if(tick>0){
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"售出1张票，剩余："+--tick);
                    }
                    else{
                        break;
                    }
                }finally{
                    lock.unlock();//释放锁一定要放在finally里，保证一定执行
                    countDownLatch.countDown();
                }
            }
        }

    }
}
