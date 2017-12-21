package classDir;

/**
 * Created by Administrator on 2017/12/8.
 */
public class cla_a {
    static {
        System.out.println("static block a ");
    }

    {
        System.out.println("block a ");
    }

    public cla_a(){
        System.out.println("constructor a ");
    }
}
