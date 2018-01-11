package javaUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    public void run() {
        Clerk clerk=new Clerk();

        Productor pro=new Productor(clerk);
        Consumer cus=new Consumer(clerk);

        new Thread(pro,"生产者 A").start();
        new Thread(cus,"消费者 B").start();
        new Thread(pro,"生产者 C").start();
        new Thread(cus,"消费者 D").start();
    }

    //店员 假如只有一个商品位置
    class Clerk{
        private int product=0;
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();

        //进货
        public void get(){
            lock.lock();

            try{
                while(product>=1){//为了避免虚假唤醒问题，应该总是使用在循环中
                    System.out.println("产品已满！");
                    try{
                        condition.await();//this.wait();
                        System.out.println("貌似有货卖出去了，再看看货够不够！");
                    }catch(InterruptedException e){
                    }
                }
                product+=10;
                System.out.println(Thread.currentThread().getName()+"进货 : 货物剩余 "+product);
                condition.signalAll();//this.notifyAll();
            }finally{
                lock.unlock();
            }
        }

        //卖货
        public void sale(){
            lock.lock();

            try{
                while(product<=0){
                    System.out.println("缺货！");
                    try {
                        condition.await();//this.wait();
                        System.out.println("听说有货了！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"消费 : 货物剩余 "+ --product);
                condition.signalAll();//this.notifyAll();
            }finally{
                lock.unlock();
            }
        }
    }

    //生产者
    class Productor implements Runnable{
        private Clerk clerk;
        public Productor(Clerk clerk){
            this.clerk=clerk;
        }
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                try{
                    Thread.sleep(200);
                }catch(InterruptedException e){
                }
                clerk.get();
            }
        }
    }

    //消费者
    class Consumer implements Runnable{
        private Clerk clerk;
        public Consumer(Clerk clerk){
            this.clerk=clerk;
        }
        @Override
        public void run() {
            for(int i=0;i<200;i++){
                clerk.sale();
            }
        }
    }
}
