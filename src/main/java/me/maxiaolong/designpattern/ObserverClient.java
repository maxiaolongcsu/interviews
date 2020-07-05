package me.maxiaolong.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/7/5
 * 观察者模式是一种经常使用的设计模式。在软件系统中对象并不是孤立存在的，一个对象行为的改变可能会导致一个或者多个其它与之存在依赖关系的
 * 定义一种一对多的依赖关系，使得每当一个对象的状态发生改变时，其他相关依赖对象皆得到通知并自动更新。
 * 又叫做：发布订阅模式，模型视图模式
 * 比如：红灯亮汽车停；绿灯亮汽车行
 * 被观察者（目标）维护观察者列表，一旦目标发生改变就通知观察者发生变化(主动通知)
 * 比如开发过程中，同一数据模型关联多张视图的情况，修改数据模型修改多张视图表示。（我自己认为核心业务逻辑改变致使观察者状态发生改变，硬编码在）
 */
public class ObserverClient {
    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();
        /**
         * 目标类内部维持一个观察者集合
         */
        Subject1 subject1 = new ConcreteSubject1();
        subject1.attach(observer);
        subject1.notifyObservers();
    }
}

interface Observer{
    void update();
}

abstract class Subject1{
    private List<Observer> observerList= new ArrayList<>();

    /**
     * 添加观察者
     * @param observer
     */
    public abstract void attach(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public abstract void detach(Observer observer);

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void notifyObservers(){
        for(Object observer: observerList){
            ((Observer)observer).update();
        }
    }
}

class ConcreteObserver implements Observer{

    @Override
    public void update() {
        System.out.println("被观察者发生修改");
    }
}

class ConcreteSubject1 extends Subject1{

    @Override
    public void attach(Observer observer) {
        getObserverList().add(observer);
    }

    @Override
    public void detach(Observer observer) {
        getObserverList().remove(observer);
    }
}