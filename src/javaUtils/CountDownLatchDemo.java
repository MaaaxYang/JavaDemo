package javaUtils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public void run() {
        final CountDownLatch latch=new CountDownLatch(50);
        LatchDemo ld= new LatchDemo(latch);

        long start=System.currentTimeMillis();

        for(int i=0;i<50;i++){
            new Thread(ld).start();
        }

        try {
            latch.await(); //直到50个人子线程都执行完，latch的值减到0时，才往下执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start) + " 毫秒");
    }

    class LatchDemo implements Runnable{
        private CountDownLatch latch;

        public LatchDemo(CountDownLatch latch){
            this.latch=latch;
        }
        @Override
        public void run() {
            String currentName = Thread.currentThread().getName();
            try{
                for(int i=0;i<=100;i++){
                    System.out.println("当前线程："+ currentName +" 进度-> "+i);
                }
            }finally{
                latch.countDown();//latch的值减一
            }
        }
    }
}
