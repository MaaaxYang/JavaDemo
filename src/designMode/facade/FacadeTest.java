package designMode.facade;

/**
 * Created by Administrator on 2017/12/20.
 */
public class FacadeTest {

    public static void run(){
        System.out.println("->外观模式");
        Computer computer = new Computer();
        computer.startUp();
        computer.shutDown();
        System.out.println();
    }
}
