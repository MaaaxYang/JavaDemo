package classDir;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/12/19.
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";
}
