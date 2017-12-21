package designMode.Adapter;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Adapter1 extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this's Adapter Targetable method2");
    }
}
