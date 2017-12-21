package designMode.bridge;

/**
 * Created by Administrator on 2017/12/20.
 */
public class BridgeTest {

    public static void run()
    {
        System.out.println("->桥接模式");
        Bridge bridge = new MyBridge();
        Sourceable sourceable1 = new SourceSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();

        Sourceable sourceable2 = new SourceSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();

        System.out.println();
    }
}
