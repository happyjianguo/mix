package test.injectcollection;

/**
 * Created by joshua on 17/4/13.
 */
public class Address {

    private String number;
    private String description;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
