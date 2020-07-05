package me.maxiaolong.designpattern;

/**
 * @author maxiaolong
 * created at 2020/7/5
 * 命令模式：将一个请求封装为对象，从而使我们可以用不同的请求对客户进行参数化。本质是对命令进行封装，将发出命令的责任和执行命令的责任分割
 */
public class CommandClient {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        //将发出命令的职责和执行命令的职责分割
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}

class Receiver{
    public void action(){
        System.out.println("Receiver action");
    }
}

class Invoker{

    /**
     * 聚合方式，Command命令对命令执行者Receiver进行关联，将其方法封装为对象
     */
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(){
        this.command.execute();
    }
}

abstract class Command{
    public abstract void execute();
}

class ConcreteCommand extends Command{

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
