package classDir;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/24.
 */
public abstract class cls_c implements Serializable{
    private static final long serialVersionUID = -3772752000122917232L;

    protected abstract void abs();

    protected void run(){
        abs();
    }


}
