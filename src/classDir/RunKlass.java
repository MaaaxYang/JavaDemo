/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package classDir;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.BitSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class RunKlass {
    public static void main(String[] args) throws Exception{
        //Class cl =  Class.forName("java.lang.String");

        //Class cl2 = String.class.getClassLoader().loadClass("java.lang.String");

//        TreeSet treeSet = new TreeSet<>();
//        treeSet.add(null);

        Integer in1 = 1;
        int in2 = 1;
        if (in1 == in2){
            System.out.println(true);
        }

        String str = "abc";
        String str2 = new String("abc");


        Integer a = 1000;
        Integer b = 2000;
        swap(a,b);
        System.out.println(a.toString());
        System.out.println(b.toString());


        SwapKlass klassa = new SwapKlass();
        SwapKlass klassb = new SwapKlass();
        klassa.value = 3000;
        klassb.value = 4000;
        System.out.println(klassa.hashCode());
        System.out.println(klassb.hashCode());
        swap2(klassa,klassb);
        System.out.println(klassa.value);
        System.out.println(klassb.value);

        HashMap hashMap = new HashMap();


        System.out.println("sdfasf".hashCode());

        Semaphore semaphore = new Semaphore(10);
        semaphore.acquire();
        semaphore.release();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        cyclicBarrier.getNumberWaiting();
        cyclicBarrier.isBroken();
        cyclicBarrier.await();
        cyclicBarrier.reset();

        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
        stampedLock.writeLock();


        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        writeLock.lock();
        writeLock.unlock();
        readLock.lock();
        readLock.unlock();

        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        selector.select();


    }

    public static void swap(Integer a ,Integer b){
        Integer c = a;
        a = b;
        b = c;
    }

    public static void swap2(SwapKlass a ,SwapKlass b){
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        a.value = 6000;
        SwapKlass c = a;
        a = b;
        b = c;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        a = new SwapKlass();
        a.value = 6000;
        System.out.println(a.hashCode());
    }

    public static class SwapKlass{
        public Integer value;
    }
}
