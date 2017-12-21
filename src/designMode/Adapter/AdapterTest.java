package designMode.Adapter;

/**
 * Created by Administrator on 2017/12/20.
 */
public class AdapterTest {
    public static void run1(){
        System.out.println("->适配器模式（类）");
        Targetable target = new Adapter1();
        target.method1();
        target.method2();
        System.out.println();
    }

    public static void run2(){
        System.out.println("->适配器模式（对象）");
        Targetable target = new Adapter2(new Source());
        target.method1();
        target.method2();
        System.out.println();
    }

    public static void run3(){
        System.out.println("->适配器模式（接口）");
        Targetable target1 = new Adapter3_1();
        Targetable target2 = new Adapter3_2();
        target1.method1();
        target1.method2();

        target2.method1();
        target2.method2();
        System.out.println();
    }
}
