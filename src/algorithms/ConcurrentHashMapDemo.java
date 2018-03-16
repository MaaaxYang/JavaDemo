/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by Administrator on 2018/1/22.
 */
public class ConcurrentHashMapDemo {
    public void run(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>(16);
        map.put("123","abc");
        map.get("123");
        map.size();

        HashMap hashMap = new HashMap(16);
        hashMap.put(1,"aa");
        hashMap.get(1);
        hashMap.remove(1);
        hashMap.size();

        ArrayList arrayList = new ArrayList(16);
        arrayList.add(1);
        arrayList.remove(new Integer(1));
        arrayList.get(0);

        HashSet hashSet = new HashSet(16);
        hashSet.add(1);
        hashSet.remove(1);

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(100);
        atomicInteger.getAndAdd(2);

    }

    public static void main(String[] args) throws Exception{
//        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>(16);
//        map.put("123","abc");
//        map.get("123");
//        map.size();

        //MutualA mutualA = new MutualA();
        //System.out.println(mutualA.hashCode());

//        VolatiteDemo demo1 = new VolatiteDemo(1,"aaa");
//        VolatiteDemo demo2 = new VolatiteDemo(2,"aaa");
//        boolean res = demo1.equals(demo2);
//        System.out.println(res);

        int res = Integer.numberOfLeadingZeros(32);
        System.out.println(res);

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        countDownLatch.await();

        StampedLock stampedLock = new StampedLock();
        stampedLock.asReadLock().lock();

        int[] arr = {1,2,3,4,5,6,8,9,10};
        int value = select(arr,0);
        System.out.println(value);


        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        Thread.sleep(1000);

        //FileChannel channel = FileChannel.open(null,null);
        //channel.read(byteBuffer);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.get(0);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.get(2);

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);
        atomicInteger.incrementAndGet();

        System.out.println("end");

        arrayList.wait();
//
//        FileInputStream inputStream = new FileInputStream(null);
//        inputStream.read();
        Date now = new Date();
        Thread.sleep(1000);
        Date after = new Date();
        System.out.println(now.before(after));

    }


    public static int select(int[] arr,int value){
        //Arrays.sort(arr);
        int minIndex = 0;
        int maxIndex = arr.length -1;
        int middleIndex = minIndex + ((maxIndex - minIndex)/2);
        while (true){
            if (arr[middleIndex]==value){
                return middleIndex;
            }

            if (minIndex==maxIndex){
                return -1;
            }

            if (arr[middleIndex]<value){
                minIndex = middleIndex + 1;
                middleIndex = minIndex + ((maxIndex - minIndex)/2);
                if (middleIndex>=arr.length){
                    return -1;
                }
            }

            if (arr[middleIndex]>value){
                maxIndex = middleIndex - 1;
                middleIndex = minIndex + ((maxIndex - minIndex)/2);
                if (middleIndex<0){
                    return -1;
                }
            }
        }
    }


}
