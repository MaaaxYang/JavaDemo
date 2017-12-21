package designMode.bridge;

/**
 * Created by Administrator on 2017/12/20.
 */
public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this's bridge SourceSub1 method");
    }
}
