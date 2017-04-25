package test.designpattern.observer;

import java.util.Vector;

/**
 * 观察者模式
 */

abstract class Subject {

    private Vector<Observer> obs = new Vector();

    public void addObserver(Observer obs) {
        this.obs.add(obs);
    }

    public void delObserver(Observer obs) {
        this.obs.remove(obs);
    }

    protected void notifyObserver() {
        for (Observer o : obs) {
            o.update();
        }
    }

    public abstract void doSomething();
}

class ConcreteSubject extends Subject {
    public void doSomething() {
        System.out.println("Something happened to subject");
        this.notifyObserver();
    }
}

interface Observer {
    public void update();
}

class ConcreteObserver1 implements Observer {
    public void update() {
        System.out.println("Observer1 get message & processing...");
    }
}

class ConcreteObserver2 implements Observer {
    public void update() {
        System.out.println("Observer2 get message & processing...");
    }
}

public class Client {

    public static void main(String[] args) {
        Subject sub = new ConcreteSubject();
        sub.addObserver(new ConcreteObserver1());
        sub.addObserver(new ConcreteObserver2());
        sub.doSomething();
    }
}
