package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/4
 * 结构型设计模式：关注类或类与对象之间的组合以构成更加复杂的系统
 * 1. 类结构型设计模式：关注类之间的组合，类之间的组合一般只存在继承关系和实现关系
 * 2. 对象结构型设计模式：关注类与对象之间的组合，类与对象之间的关联可以使用组合和聚合，满足合成复用原则（大部分结构型设计模式为对象结构型设计模式）
 *
 * 适配器设计模式(Adapter/Wrapper)主要是将一个类的接口转换为用户希望的另一接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 */

public class ClassAdapterClient {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

class Adaptee{
    public void specialRequest(){
        System.out.println("special request");
    }
}

interface Target{
    /**
     * 客户端目标类所期望的请求方法
     */
    void request();
}

class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        specialRequest();
    }
}


