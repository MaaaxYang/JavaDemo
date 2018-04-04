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
public class InnerClass {

    public class KlassAAA{

    }

    public static class KlassBBB{

    }

    private class KlassCCC{
        int v = 0;
        void func(){

        }
    }

    private static class KlassDDD{
        static int v = 0;

        void func(){
            System.out.println(v++);
        }

        static void func2(){
            System.out.println("func2");
        }
    }

    public abstract class KlassEEE{

    }

    public abstract static class KlassFFF{

    }

    public static void main(String[] args){
        InnerClass innerClass = new InnerClass();
        innerClass.func();
    }

    public void func(){
        KlassAAA aaa = new KlassAAA();
        KlassBBB bbb = new KlassBBB();
        KlassCCC ccc = new KlassCCC();
        KlassDDD ddd = new KlassDDD();
        ddd.func();
        KlassDDD ddd2 = new KlassDDD();
        ddd2.func();
        //KlassFFF eee = new KlassFFF();

    }
}
