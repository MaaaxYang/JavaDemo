/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package servlet;

import java.util.concurrent.locks.LockSupport;

public class Demo {
    public static void main(String[] args){
        int i = 0;
        while (true){

            System.out.println(i++);
            LockSupport.parkNanos(1000*1000*1000);

            "aaa".contains("a");
        }
    }
}
