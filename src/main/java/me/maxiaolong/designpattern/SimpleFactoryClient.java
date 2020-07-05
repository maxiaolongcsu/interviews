package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/2
 * 简单工厂模式，工厂类只需要知道参数便可以获得相应对象
 * 优点：
 * 缺点：1) 如果增加产品，必须要修改工厂类（违背开闭原则）
 * 例子：
 *  冰箱厂 生产大冰箱，中冰箱，小冰箱
 */
public class SimpleFactoryClient {
    public static void main(String[] args) {
        // 创建工厂的过程可以使用简单工厂进一步隐藏创建细节
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();
    }
}

class ShapeFactory{
    ShapeFactory(){
    }

    public Shape getShape(String shapeDescription){
        switch (shapeDescription){
            case "Triangle":
                return new Triangle();
            case "Rectangle":
                return new Rectangle();
            case "Circle":
                return new Circle();
            default:
                return null;
        }
    }
}


interface Shape{

    /**
     * 绘制图形
     */
    void draw();
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a triangle shape");
    }
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a rectangle shape");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw a circle shape");
    }
}

