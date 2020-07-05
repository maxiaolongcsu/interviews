package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/4
 * 代理模式：当直接访问某些对象存在问题是可以通过一个代理对象间接访问，为了保证客户端使用的透明性，所访问的真实对象与代理对象都要实现相同的接口（组合）
 * 使用组合的方式(且使用的是真实对象作为类的声明，设置为私有)，代理类与真实类需要实现同样的接口，客户端应该完全无法接触真实客体
 */
public class ProxyClient {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

abstract class Subject{
    public abstract void request();
}

class RealSubject extends Subject{

    @Override
    public void request() {
        System.out.println("real subject");
    }
}

class Proxy extends Subject{

    /**
     * 一定要使用真实对象
     */
    private RealSubject realSubject = new RealSubject();

    @Override
    public void request() {
        beforeRequest();
        realSubject.request();
        afterRequest();
    }

    public void beforeRequest(){
        System.out.println("before proxy");
    }

    public void afterRequest(){
        System.out.println("after proxy");
    }
}