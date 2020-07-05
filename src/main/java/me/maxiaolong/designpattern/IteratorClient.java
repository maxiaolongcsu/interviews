package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/5
 * 迭代器模式用于对一个聚合对象进行遍历。聚合对象只负责数据存储，遍历对象职责交由迭代器来完成。
 */
public class IteratorClient {
    public static void process(Aggregate aggregate){
        Iterator iterator = aggregate.createIterator();
        while(!iterator.isLast()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        process(aggregate);
    }
}

/**
 * 先定义高层接口
 */
interface Aggregate{
    Iterator createIterator();
}

interface Iterator{
    void first();
    void next();
    boolean isLast();
    Object currentItem();
}


/**
 * 主聚合类的主要职责依然是数据存储
 */
class ConcreteAggregate implements Aggregate{

    private Object[] objArr = {"0", "1", "2", "3", "4"};

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator();
    }

    /**
     * 私有内部类：通过私有迭代器内部类控制访问流程
     */
    private class ConcreteIterator implements Iterator{

        private int currentIndex = 0;

        @Override
        public void first() {
            currentIndex = 0;
        }

        @Override
        public void next() {
            currentIndex++;
        }

        @Override
        public boolean isLast() {
            return currentIndex == objArr.length;
        }

        @Override
        public Object currentItem() {
            return objArr[currentIndex];
        }
    }
}