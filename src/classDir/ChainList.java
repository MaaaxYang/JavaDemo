/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package classDir;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/3/22.
 */
public class ChainList<E> {

    public Node<E> first;

    public Node<E> last;

    public int size;

    private class Node<E>{
        public E val;
        public Node next;
        public Node prev;

        public Node(E val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addLast(E val){
        final Node<E> l = last;
        Node newNode = new Node(val,null,l);
        last = newNode;
        if (l==null){
            first = newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }

    public void addFisrt(E val){
        final Node<E> f = first;
        Node newNode = new Node(val,f,null);
        first = newNode;
        if (f==null){
            first = newNode;
        }
        else{
            f.prev = newNode;
        }
        size++;
    }

    public Node<E> removeFirst(){
        if (first!=null){
            Node<E> oldFirst = first;
            Node<E> newFirst = oldFirst.next;
            first = newFirst;
            return oldFirst;
        }
        return null;
    }

    public Node<E> removeLast(){
        if (last!=null){
            Node<E> oldLast = last;
            Node<E> newLast = oldLast.prev;
            oldLast.next = null;
            oldLast.prev = null;
            newLast.next = null;
            last = newLast;
            return oldLast;
        }
        return null;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.get(0);

        HashMap hashMap = new HashMap();
        hashMap.put(null,null);
        hashMap.get(null);
        hashMap.size();
        hashMap.hashCode();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(null,null);
        concurrentHashMap.size();

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        hashtable.size();

        TreeMap treeMap = new TreeMap();
        treeMap.put(null,null);
        treeMap.size();

        treeMap.tailMap("");



        LinkedHashMap linkedHashMap = new LinkedHashMap(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {

                return super.removeEldestEntry(eldest);
            }
        };
        linkedHashMap.put(null,null);


        ExecutorService executorService = Executors.newFixedThreadPool(0);
        executorService.execute(null);
        //executorService.submit(null);
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(100000),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("线程池阻塞队列已满");
                    }
                }
        );

        ThreadLocal threadLocal = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return super.initialValue();
            }
        };
        threadLocal.set(null);
        threadLocal.get();

        Thread thread = new Thread();


        Integer x = 5;
        int y = 5;
        System.out.println(x==y);

        synchronized (ChainList.class){

        }

    }
}
