package test.observe;

import java.util.Observable;

/**
 * @author chuanshi - 2018/11/4 21:04
 */
class House extends Observable {
    private double price;

    public House(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (this.price != price) {
            this.price = price;
            setChanged();  //标注价格已经被更改
            this.notifyObservers(price);  //通知观察者数据已被更改
        }
    }

    @Override
    public String toString() {
        return "当前房价为：" + price;
    }
}
