/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package classDir;

/**
 * Created by Administrator on 2018/3/22.
 */
public class InnerClassTwo {
    public void func(){
        InnerClass innerClass = new InnerClass();
        InnerClass.KlassAAA aaa = innerClass.new KlassAAA();

        InnerClass.KlassBBB bbb = new InnerClass.KlassBBB();
        // 静态内部类在外部不能用对象.new
        //InnerClass.KlassBBB bbb = innerClass.new KlassBBB();

    }
}
