package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/3
 * 增加产品族
 *
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        // 工厂new的操作可以使用简单工厂代替
        AbstractFactory factory = new BigFactory();
        AbstractIceBox iceBox = factory.createIceBox();
        iceBox.describeIceBox();
    }
}

interface AbstractFactory{
    /**
     * 生产冰箱
     * @return
     */
    AbstractIceBox createIceBox();

    /**
     * 生产空调
     * @return
     */
    AbstractAirCondition createAirCondition();
}

class BigFactory implements  AbstractFactory{

    @Override
    public AbstractIceBox createIceBox() {
        return new BigIceBox();
    }

    @Override
    public AbstractAirCondition createAirCondition() {
        return new BigAirCondition();
    }
}

class MediumFactory implements AbstractFactory{

    @Override
    public AbstractIceBox createIceBox() {
        return new MediumIceBox();
    }

    @Override
    public AbstractAirCondition createAirCondition() {
        return new MediumAirCondition();
    }
}

class SmallFactory implements AbstractFactory{

    @Override
    public AbstractIceBox createIceBox() {
        return new SmallIceBox();
    }

    @Override
    public AbstractAirCondition createAirCondition() {
        return new SmallAirCondition();
    }
}

interface AbstractIceBox {
    /**
     * 生产冰箱接口
     */
    void describeIceBox();
}

class BigIceBox implements AbstractIceBox {

    @Override
    public void describeIceBox() {
        System.out.println("describe big icebox");
    }
}

class MediumIceBox implements AbstractIceBox {

    @Override
    public void describeIceBox() {
        System.out.println("describe medium icebox");
    }
}

class SmallIceBox implements AbstractIceBox {

    @Override
    public void describeIceBox() {
        System.out.println("describe small icebox");
    }
}

interface AbstractAirCondition {
    /**
     * 生产空调接口
     */
    void describeAirCondition();
}

class BigAirCondition implements AbstractAirCondition {

    @Override
    public void describeAirCondition() {
        System.out.println("describe big air condition");
    }
}

class MediumAirCondition implements AbstractAirCondition {

    @Override
    public void describeAirCondition() {
        System.out.println("describe medium air condition");
    }
}

class SmallAirCondition implements AbstractAirCondition {

    @Override
    public void describeAirCondition() {
        System.out.println("describe small air condition");
    }
}