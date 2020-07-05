package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/3
 * 定义：创建一个包含多个组成部分的复杂对象，可以返回一个完整的产品对象给用户
 */
public class BuilderClient {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}

/**
 * 负责安排复杂对象的建造次序
 */
class Director{

    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 控制对象构建顺序
     */
    public Product construct(){
        this.builder.buildPartA();
        this.builder.buildPartB();
        this.builder.buildPartC();
        return this.builder.getResult();
    }
}

/**
 * 产品以及部分
 */
class Product{
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
}

abstract class Builder{

    /**
     * 申明为受保护的，便于子类使用
     */
    protected Product product = new Product();

    abstract void buildPartA();

    abstract void buildPartB();

    abstract void buildPartC();

    public Product getResult(){
        return this.product;
    }
}

class ConcreteBuilder extends Builder{

    @Override
    public void buildPartA(){
        this.product.setPartA("partA");
    }

    @Override
    public void buildPartB(){
        this.product.setPartB("partB");
    }

    @Override
    public void buildPartC(){
        this.product.setPartC("partC");
    }
}

