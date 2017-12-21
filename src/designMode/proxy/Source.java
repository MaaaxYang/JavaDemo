package designMode.proxy;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("this's Proxy Source method");
    }
}
