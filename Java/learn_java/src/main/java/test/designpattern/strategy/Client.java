package test.designpattern.strategy;

/**
 * 策略模式
 */

interface IStrategy {
    public void doSomething();
}

class ConcreteStrage1 implements IStrategy {
    public void doSomething() {
        System.out.println("Strategy 1");
    }
}

class ConcreteStrage2 implements IStrategy {
    public void doSomething() {
        System.out.println("Strategy 2");
    }
}

class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doSomething();
    }
}


public class Client {
    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrage1());
        context.execute();

        context = new Context(new ConcreteStrage2());
        context.execute();
    }
}
