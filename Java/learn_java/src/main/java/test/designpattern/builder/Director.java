package test.designpattern.builder;

/**
 * Created by joshua on 17/4/24.
 */
public class Director {

    private Builder builder = new ConcreateBuilder();

    public Product getAProduct() {
        builder.setPart("BMW", "X7");
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPart("Audi", "Q5");
        return builder.getProduct();
    }

}
