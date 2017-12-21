package designMode.decorator;

/**
 * Created by Administrator on 2017/12/20.
 */
public class DecoratorTest {
    public static void run(){
        System.out.println("->装饰器模式");
        Sourceable sourceable = new Decorator(new Source());
        sourceable.method();
        System.out.println();
    }
}
