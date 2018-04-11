package someTopics;

public class SynchronizedTest {
    public synchronized void test1()
    {
        //System.out.println("1");
    }

    public static synchronized void test2()
    {
        //System.out.println("2");
    }

    public void test3(){
        synchronized (this){
            //System.out.println("3");
        }
    }
}
