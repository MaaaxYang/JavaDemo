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
public class KlassChild extends KlassBasic{
    public static int value3 = 12;

    static {
        System.out.println("13");
    }

    public int value4 = 14;

    {
        System.out.println("15");
    }

    public KlassChild(){
        System.out.println("16");
    }

}