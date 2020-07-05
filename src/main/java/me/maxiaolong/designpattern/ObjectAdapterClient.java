package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/4
 */
public class ObjectAdapterClient {
    public static void main(String[] args) {
        Target1 target1 = new Adapter1();
        target1.request();
    }
}

abstract class Target1{
    public abstract void request();
}

class Adaptee1{
    public void specialRequest(){
        System.out.println("special request");
    }
}

class Adapter1 extends Target1{
    private Adaptee1 adaptee1 = new Adaptee1();

    @Override
    public void request() {
        adaptee1.specialRequest();
    }
}
