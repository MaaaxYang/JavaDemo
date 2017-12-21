package designMode.proxy;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        System.out.println("this's proxy after");
    }
    private void before() {
        System.out.println("this's proxy before");
    }
}
