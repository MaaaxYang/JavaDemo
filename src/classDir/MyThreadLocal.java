package classDir;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MyThreadLocal {
    public static ThreadLocal<cla_a> tl_class = new ThreadLocal<cla_a>(){
        @Override
        protected cla_a initialValue() {
            return new cla_a();
        }
    };

    public static cla_a get(){
        return tl_class.get();
    }
}
