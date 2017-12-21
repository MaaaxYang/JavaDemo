package designMode.bridge;

/**
 * Created by Administrator on 2017/12/20.
 */
public class MyBridge extends Bridge {
    @Override
    public void method(){
        getSourceable().method();
    }
}
