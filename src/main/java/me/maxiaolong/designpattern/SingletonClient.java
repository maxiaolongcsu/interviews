package me.maxiaolong.designpattern;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @author maxiaolong
 * created at 2020/7/3
 */
public class SingletonClient {

}

/**
 * 饿汉模式
 */
class SingletonV1{
    private static SingletonV1 singletonV1 = new SingletonV1();

    private SingletonV1(){}

    public static SingletonV1 getInstance(){
        return singletonV1;
    }
}

/**
 * 懒汉模式
 */
class SingletonV2{
    private static SingletonV2 singletonV2;

    private SingletonV2(){}

    /**
     * 懒汉模式线程不安全
     * @return
     */
    public static SingletonV2 getInstance(){
        if(singletonV2==null){
            //没有设置为临界区，可自由访问
            singletonV2 = new SingletonV2();
        }
        return singletonV2;
    }
}

class SingletonV3{
    /**
     * volatile关键字可以使指令重排序失效
     */
    private static volatile SingletonV3 singletonV3;

    private SingletonV3(){}

    public static SingletonV3 getInstance(){
        if(singletonV3==null){
            // 如果对整个方法加synchronized，同步块太大，不利于并发
            synchronized (Object.class){
                if(singletonV3==null){
                    // 过程 1. 内存空间开辟 2. 指针指向 3. 对象初始化 其中2，3是进行指令重排序优化的
                    singletonV3 = new SingletonV3();
                }
            }
        }
        return singletonV3;
    }
}

/**
 * 延迟初始化占位类模式
 * 实现延迟初始化的同时，保证线程安全
 * 原理：1. 外部类加载时不要求内部类加载，即SingletonV4加载时，不要求内部类InstanceHolder被加载；只有当外部类调用getInstance静态方法时内部类才加载并完成初始化操作；
 *      2. 多线程进行类的初始化时，JVM保证只有一条线程进行类的初始化，其它线程则会被阻塞。
 */
class SingletonV4{
    public static class InstanceHolder{
        public static SingletonV4 singletonV4 = new SingletonV4();
    }

    private SingletonV4(){}

    public static SingletonV4 getInstance(){
        return InstanceHolder.singletonV4;
    }
}


