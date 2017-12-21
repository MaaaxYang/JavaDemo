package designMode.Adapter;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Adapter2 implements Targetable {

    private Source source;

    public Adapter2(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this's Adapter2 Targetable method2");
    }
}
