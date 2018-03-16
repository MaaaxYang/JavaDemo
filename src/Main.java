/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import algorithms.ConcurrentHashMapDemo;
import algorithms.DFS;
import classDir.*;
import designMode.Adapter.AdapterTest;
import designMode.bridge.BridgeTest;
import designMode.decorator.DecoratorTest;
import designMode.facade.FacadeTest;
import designMode.proxy.ProxyTest;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.annotation.Annotation;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {



    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        /**适配器模式**/
        //类的适配器模式 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
        AdapterTest.run1();
        //对象的适配器模式 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
        AdapterTest.run2();
        //接口的适配器模式 当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
        AdapterTest.run3();

        /**装饰器模式**/
        DecoratorTest.run();

        /**代理模式**/
        ProxyTest.run();

        /**外观模式**/
        FacadeTest.run();

        /**桥接模式**/
        BridgeTest.run();

        /**
         * 组合模式 （上下依赖关系、二叉树）
         * 享元模式 （数据库连接池、主要目的是实现对象的共享）
         * 策略模式 （策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户）
         * 模板方法模式
         * 观察者模式
         *
         * **/


//        DFS dfs = new DFS();
//        dfs.depthFirstSearch();
//
//        try{
//            FileChannel channel = new FileInputStream("").getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//
//            int bytesRead = channel.read(byteBuffer);
//
//            while (bytesRead!=-1){
//                byteBuffer.flip();
//                while(byteBuffer.hasRemaining()){
//                    System.out.println((char)byteBuffer.get());
//                }
//                byteBuffer.compact();
//                bytesRead = channel.read(byteBuffer);
//            }
//            channel.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//
//        }


//        String str = "";
//        StringBuilder strBuilder = new StringBuilder("123");
//        StringBuffer strBuffer = new StringBuffer("123");
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for(int i = 0;i<11;i++){
//            arrayList.add(i);
//        }
//
//        HashMap<Integer,String> map = new HashMap<>();
//        for(int i = 0;i<17;i++){
//            if (i==11){
//                map.put(i,"bbb-" + i);
//            }
//            map.put(i,"aaa-" + i);
//        }
//        map.get(12);
//
//        Integer it = 1;
//        String str2 = it.toString();
//
//        System.out.println(str2);



//        BigDecimal amount = (new BigDecimal(20000).subtract(new BigDecimal(120)));
//        System.out.println(amount);
        //System.out.println("Hello World!");

//        cls_a a = new cls_a();
//        a.start();

        //new cla_b();
        //new cla_b();



//        MyThread myTheadA = new MyThread("A");
//        MyThread myTheadB = new MyThread("B");
//        MyThread myTheadC = new MyThread("C");
//        MyThread myTheadD = new MyThread("D");
//        MyThread myTheadE = new MyThread("E");
//        MyThread myTheadF = new MyThread("F");

//        MyThread myTheadA = new MyThread(MyThreadLocal.tl_class);
//        MyThread myTheadB = new MyThread(MyThreadLocal.tl_class);
//        MyThread myTheadC = new MyThread(MyThreadLocal.tl_class);
//        MyThread myTheadD = new MyThread(MyThreadLocal.tl_class);
//        MyThread myTheadE = new MyThread(MyThreadLocal.tl_class);
//        MyThread myTheadF = new MyThread(MyThreadLocal.tl_class);
//
//        long id = Thread.currentThread().getId();
//        System.out.println("当前主线程：-> " + id + " lv ：" + Thread.currentThread().getPriority());
//
//        Thread.currentThread().setPriority(4);
//        Thread thread = new Thread(myTheadA);
//
//        System.out.println("lv: "+thread.getPriority());
//
//        System.out.println("子线程：" + thread.getId() + " active：" + thread.isAlive());
//        //thread.setPriority(7);
//        thread.start();
//
//        System.out.println("子线程：" + thread.getId() + " active：" + thread.isAlive());
//        //thread.run();
//
//        System.out.println("当前主线程：-> end " + id + " lv ：" + Thread.currentThread().getPriority());

//        System.out.println("--------------------------------------");
//
//        try{
//             Method[] methods = ClassLoader.getSystemClassLoader().loadClass("classDir.MyAnnotationTest").getMethods();
//             for(Method method:methods){
//
//                 if (method.isAnnotationPresent(MyAnnotation.class)){
//                     MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
//
//                     //Object val = field.get("value");
//                     //System.out.println(val);
//                     System.out.println(annotation.value());
//                 }
//             }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        /**
         * 链表反转
         */
//        Main m = new Main();
//        m.test();
//        try{
//
//            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//            FileChannel fileChannel = (new FileInputStream("")).getChannel();
//            fileChannel.read(byteBuffer);
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        ThreadLocal threadLocal = new ThreadLocal();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
//        String str = dateFormat.format(new Date());
//        System.out.println(str);


        //ConcurrentHashMapDemo concurrentHashMapDemo = new ConcurrentHashMapDemo();
        //concurrentHashMapDemo.run();
//
        System.out.println("插入数据...");
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new LinkedHashSet<>();
        Date time11 = new Date();
        for(int i = 0;i<1000000;i++){
            list.add(new Integer(i));
        }
        Date time22 = new Date();
        System.out.println("list 插入耗时：" + (time22.getTime()-time11.getTime()));

        for (int i = 0;i<5;i++){
            System.out.println("=============== "+i+"==============");

//        for(int i = 0;i<10000000;i++){
//            set.add(new Integer(i));
//        }
            Date time33 = new Date();
            for (Integer it : list){

            }
            Date time44 = new Date();
//        for (Integer it : set){
//
//        }
            Date time55 = new Date();

//        System.out.println("set 插入耗时：" + (time33.getTime()-time22.getTime()));

//        System.out.println("list 遍历耗时：" + (time44.getTime()-time33.getTime()));
//        System.out.println("set 遍历耗时：" + (time55.getTime()-time44.getTime()));

            Set<Integer> set2 = new LinkedHashSet<>();
            List<Integer> list2 = new LinkedList<>();

            Date t1 = new Date();
            set2.addAll(list);
            Date t2 = new Date();
//        list2.addAll(set);
            Date t3 = new Date();
            System.out.println("set addAll 耗时："+(t2.getTime()-t1.getTime()));
//        System.out.println("list addAll 耗时："+(t3.getTime()-t2.getTime()));

//            System.out.println("转换耗时计算。。");
            Date time1 = new Date();
            Set<Integer> st = list.stream().collect(Collectors.toSet());
            Date time2 = new Date();
//        List<Integer> ls = set.stream().collect(Collectors.toList());
            Date time3 = new Date();
            System.out.println("list->set 耗时：" + (time2.getTime()-time1.getTime()));
//        System.out.println("set->list 耗时：" + (time3.getTime()-time2.getTime()));

        }


//        Date date = convertToDay(new Date());
//        System.out.println(date);
//
        Reference temp = new WeakReference(null);

    }

    public static final Date convertToDay(Date datetime){
        if (datetime==null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year,month,date,0,0,0);
        return calendar.getTime();
    }

    public void test()
    {

        Node node = new Node(1);
        Node first = node;
        for(int i = 2;i<4;i++){
            node.setNext(new Node(i));
            node = node.next;
        }

        reverse2(first);
        while (node!=null){
            System.out.print(node.getValue()+" -> ");
            node = node.next;
        }
    }

    class Node{
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * 行为描述：
     *
     * @param current
     * @return
     */
    public Node reverse(Node current){
        // 上一个节点
        Node previous = null;
        // 下一个节点
        Node next = null;

        while (current!=null){
            // 缓存下一个节点
            next = current.next;
            // 将上一个节点覆盖到下一个节点
            current.next = previous;
            // 将当前节点缓存到 上一个节点，用于给下个节点使用
            previous = current;
            // 切换到下一个节点
            current = next;
        }

        return current;
    }

    /**
     * 递归
     * @param current
     * @return
     */
    public Node reverse2(Node current){
        if (current==null||current.next==null){
            return current;
        }
        // 用递归找到链表尾部
        reverse2(current.next);
        current.next.next = current;
        current.next = null;

        return current;
    }

}
