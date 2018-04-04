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
public class KlassBasic {
    public static int value1 = 2;

    static {
        System.out.println("3");
    }

    public int value2 = 4;

    {
        System.out.println("5");
    }

    public KlassBasic(){
        System.out.println("6");
    }
}
