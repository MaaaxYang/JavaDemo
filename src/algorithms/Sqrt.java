/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package algorithms;

public class Sqrt {

    //java实现的sqrt类和方法
    public static double sqrt(double n)
    {
        if (n<0) return Double.NaN;
        double err = 1e-15;
        double t = n;

        while (Math.abs(t - n/t) > err*t){
            t = (n/t + t)/2;
        }
        return t;
    }

    public static void main(String[] args)
    {
        System.out.println(Sqrt.sqrt(2));
    }

// 2的平方根的求解结果
// >>1.414213562373095

    public static double sqrt2(double n){
        if (n<0){
            return Double.NaN;
        }
        double err = 1e-15;
        double t = n ;
        while (Math.abs(t-n/t)>err*t){
            t = (n/t+t)/2;
        }
        return t;
    }
}
