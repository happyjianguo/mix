package test.designpattern.mediator;

/**
 * 中介者模式
 */

abstract class AbstractColleague {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void setNumber(int number, AbstractMediator am);
}

class ColleagueA extends AbstractColleague {
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}

class ColleagueB extends AbstractColleague {
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffactA();
    }
}

abstract class AbstractMediator {
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }

    public abstract void AaffectB();

    public abstract void BaffactA();
}

class Mediator extends AbstractMediator {

    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    public void AaffectB() {
        int number = A.getNumber();
        B.setNumber(number * 10);
    }

    public void BaffactA() {
        int number = B.getNumber();
        A.setNumber(number / 10);
    }
}

public class Client {

    public static void main(String[] args) {
        AbstractColleague collA = new ColleagueA();
        AbstractColleague collB = new ColleagueB();

        AbstractMediator am = new Mediator(collA, collB);

        System.out.println("==========通过设置A影响B==========");
        collA.setNumber(1000, am);
        System.out.println("collA的number值为：" + collA.getNumber());
        System.out.println("collB的number值为A的10倍：" + collB.getNumber());

        System.out.println("==========通过设置B影响A==========");
        collB.setNumber(1000, am);
        System.out.println("collB的number值为：" + collB.getNumber());
        System.out.println("collA的number值为B的0.1倍：" + collA.getNumber());
    }
}
