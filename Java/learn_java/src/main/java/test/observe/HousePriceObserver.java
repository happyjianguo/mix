package test.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author chuanshi - 2018/11/4 21:06
 */
public class HousePriceObserver implements Observer {

    private String name;

    public HousePriceObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof House) {
            System.out.println("observer " + name + "noticed that: " + arg);
        }
    }

    public static void main(String[] args) {

        House house = new House(10000);
        HousePriceObserver observerA = new HousePriceObserver("A");
        HousePriceObserver observerB = new HousePriceObserver("B");

        house.addObserver(observerA);
        house.addObserver(observerB);

        System.out.println(house);
        house.setPrice(6000);
        house.setPrice(8000);
    }
}
