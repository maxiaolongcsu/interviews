package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/3
 * 相比于简单工厂，增加了抽象工厂类(抽象工厂类仅用于创建高层接口) 产品依然是单一种类产品
 * 例子：增加具体产品不需要修改原有工厂代码，只需要在增加具体产品的基础上增加具体工厂（开闭原则） 即增加产品等级更加满足开闭原则
 */
public class FactoryMethodClient {
    public static void main(String[] args) {
        LogFactory logFactory = new FileLogFactory();
        Log log = logFactory.createLog();
        log.writeLog();
    }
}

interface LogFactory{

    /**
     * 创建Log
     * @return
     */
    Log createLog();
}

class FileLogFactory implements LogFactory{

    @Override
    public Log createLog() {
        return new FileLog();
    }
}

class DatabaseLogFactory implements LogFactory{

    @Override
    public Log createLog() {
        return new DatabaseLog();
    }
}

interface Log{
    /**
     * 写日志
     */
    void writeLog();
}

class FileLog implements Log{

    @Override
    public void writeLog() {
        System.out.println("write file log");
    }
}

class DatabaseLog implements Log{

    @Override
    public void writeLog() {
        System.out.println("write database log");
    }
}


