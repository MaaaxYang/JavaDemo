package javaBase;

public class testKlass implements whatInterface {

    @Override
    public void func() {
        System.out.println(vl);
    }


    public static void main(String[] args){
        testKlass t = new testKlass();
        t.func();
    }
}
