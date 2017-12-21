import classDir.*;
import designMode.Adapter.AdapterTest;
import designMode.bridge.BridgeTest;
import designMode.decorator.DecoratorTest;
import designMode.facade.FacadeTest;
import designMode.proxy.ProxyTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Main {

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


        BigDecimal amount = (new BigDecimal(20000).subtract(new BigDecimal(120)));
        System.out.println(amount);
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

    }
}
