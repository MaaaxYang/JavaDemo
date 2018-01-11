package javaUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadJiaoTiDemo {

    public void run() {
        AlternateDemo ad=new AlternateDemo();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=20;i++){
                    ad.loopA(i);
                }
            }

        },"A").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=20;i++){
                    ad.loopB(i);
                }
            }

        },"B").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=20;i++){
                    ad.loopC(i);
                    System.out.println("-----------------------------------");
                }
            }

        },"C").start();
    }

    class AlternateDemo{
        private int number=1;//当前正在执行线程的标记
        private Lock lock=new ReentrantLock();
        private Condition condition1=lock.newCondition();
        private Condition condition2=lock.newCondition();
        private Condition condition3=lock.newCondition();

        /*
         * @param totalLoop:循环第几轮
         */
        public void loopA(int totalLoop){
            lock.lock();
            try{
                //1.判断
                if(number!=1){
                    condition1.await();
                }

                //2.打印
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);

                //3.唤醒
                number=2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }

        public void loopB(int totalLoop){
            lock.lock();
            try{
                //1.判断
                if(number!=2){
                    condition2.await();
                }

                //2.打印
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);

                //3.唤醒
                number=3;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }

        public void loopC(int totalLoop){
            lock.lock();
            try{
                //1.判断
                if(number!=3){
                    condition3.await();
                }

                //2.打印
                System.out.println(Thread.currentThread().getName()+"\t"+totalLoop);

                //3.唤醒
                number=1;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }
    }

    public void run2()
    {
        PrintStrDemo psd=new PrintStrDemo();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    psd.print("A");
                }
            }

        },"A").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    psd.print("B");
                }
            }

        },"B").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    psd.print("C");
                }
            }

        },"C").start();
    }

    class PrintStrDemo{
        private Lock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();
        private int position = 1;

        public void print(String str){
            lock.lock();
            try{
                if (position==1){
                    position=2;
                    System.out.print(str);
                    condition1.await();
                    condition2.signal();
                }
                if(position ==2){
                    position=3;
                    condition3.signal();
                    condition2.await();
                }
                if(position ==3){
                    position=1;
                    condition1.signal();
                    condition3.await();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }


        }

    }


}
