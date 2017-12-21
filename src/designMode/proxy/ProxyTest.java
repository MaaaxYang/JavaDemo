package designMode.proxy;

/**
 * Created by Administrator on 2017/12/20.
 */
public class ProxyTest {

    public static void run()
    {
        System.out.println("->代理模式");
        Sourceable sourceable = new Proxy(new Source());
        sourceable.method();
        System.out.println();
    }
}
