package test.designpattern;

/**
 * 工厂模式
 */

class Engine {
    public void getStyle() {
        System.out.println("Car Engine");
    }
}

class Underpan {
    public void getStyle() {
        System.out.println("Car Underpan");
    }
}

class Wheel {
    public void getStyle() {
        System.out.println("Car Wheel");
    }
}

interface ICar {
    void show();
}

class Car implements ICar {

    private Underpan underpan;
    private Engine engine;
    private Wheel wheel;

    public Car(Underpan underpan, Engine engine, Wheel wheel) {
        this.underpan = underpan;
        this.engine = engine;
        this.wheel = wheel;
    }

    public void show() {
        System.out.println("Car show");
    }
}

interface IFactory {
    ICar createCar();
}

class Factory implements IFactory {
    public ICar createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();

        ICar car = new Car(underpan, engine, wheel);
        return car;
    }
}

public class Client {

    public static void main(String[] args) {
        IFactory factory = new Factory();
        ICar car = factory.createCar();
        car.show();
    }
}
