package test.designpattern.builder;

/**
 * 建造者模式
 */

class Product {
    private String name;
    private String type;

    public void showProduct() {
        System.out.println("name: " + name);
        System.out.println("type: " + type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}

abstract class Builder {
    public abstract void setPart(String arg1, String arg2);

    public abstract Product getProduct();
}

class ConcreateBuilder extends Builder {
    private Product product = new Product();

    public Product getProduct() {
        return product;
    }

    public void setPart(String arg1, String arg2) {
        product.setName(arg1);
        product.setType(arg2);
    }
}

public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        Product product1 = director.getAProduct();
        product1.showProduct();

        Product product2 = director.getBProduct();
        product2.showProduct();
    }
}
