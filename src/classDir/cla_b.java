package classDir;

/**
 * Created by Administrator on 2017/12/8.
 */
public class cla_b extends cla_a {
    static {
        System.out.println("static block b ");
    }

    {
        System.out.println("block b ");
    }

    public cla_b(){
        System.out.println("constructor b ");
    }
}
