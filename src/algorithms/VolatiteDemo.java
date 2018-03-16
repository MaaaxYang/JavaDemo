/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/3/2.
 */
public class VolatiteDemo {

    public VolatiteDemo(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object demo) {
        if (demo instanceof VolatiteDemo){
            if (name.equals(((VolatiteDemo)demo).getName())){
                return true;
            }
        }
        return false;
    }

    public void run(){
        age++;
    }

    public static void main(String[] args){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("aaa");
        threadLocal.get();
        threadLocal.remove();

        LockSupport.parkNanos(100);

        ReferenceQueue<Integer> referenceQueue = new ReferenceQueue<>();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(20);
        byteBuffer.clear();

        Object obj = new Object();

        synchronized (Object.class){

        }
        Long lo = 1L;
        lo.hashCode();
        Integer it = 1;
        it.hashCode();
        //Thread.sleep(100);

    }
}
