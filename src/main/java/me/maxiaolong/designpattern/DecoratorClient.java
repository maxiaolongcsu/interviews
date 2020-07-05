package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/4
 * 装饰模式是一种替换继承的技术，他通过一种无序定义子类的方式给对象动态增加职责，使用对象之间的关联关系取代类之间的继承关系（聚合）
 */
public class DecoratorClient {
    public static void main(String[] args) {
        //创建对象
        Component concreteComponent = new ConcreteComponent();
        Decorator concreteDecorator = new ConcreteDecorator2(concreteComponent);
        //same method, add additional method
        concreteDecorator.operation();
    }
}

abstract class Component{
    public abstract void operation();
}

class ConcreteComponent extends Component{

    @Override
    public void operation() {
        System.out.println("concrete component operation");
    }
}

class Decorator extends Component{

    private Component component;

    public  Decorator(Component component){
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator1 extends Decorator{
    private int addedState;

    public ConcreteDecorator1(Component component) {
        super(component);
    }
}

class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        getComponent().operation();
        addedBehavior();
    }

    public void addedBehavior(){
        System.out.println("add behavior");
    }
}

