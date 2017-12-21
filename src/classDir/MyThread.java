package classDir;

import java.lang.reflect.InvocationHandler;

/**
 * Created by Administrator on 2017/12/7.
 */
public class MyThread implements Runnable {

    private String threadName;

    private ThreadLocal<cla_a> cla;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public MyThread(ThreadLocal<cla_a> cla) {
        this.cla = cla;
    }

    @Override
    public void run() {

        int cnt = 0;
        while (true){
            try{
                cnt++;
//                System.out.println("线程："+threadName+" id -> "
//                        + Thread.currentThread().getId() + " cnt：【"+cnt+"】 active："
//                        + Thread.currentThread().isAlive() + " lv： "
//                        + Thread.currentThread().getPriority());
//                if (cnt>=20){
//                    return;
//                }
                System.out.println("线程："+Thread.currentThread().getId()+" cla :"+ cla.get().toString());

                Thread.sleep(1000l);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
