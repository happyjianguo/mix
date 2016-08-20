package com.atguigu.spring.beans;

/**
 * Created by joshua on 16/5/28.
 */
public class Car {

    private String brand;

    public Car(String brand, String corp, int price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String corp;
    private int price;
    private int maxSpeed;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
