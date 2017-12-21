package designMode.decorator;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("this's Decorator begin");
        source.method();
        System.out.println("this's Decorator after");
    }
}
