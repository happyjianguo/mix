package test.springevent;

/**
 * Created by joshua on 17/4/13.
 */
public class HelloWorld {

    private String message;

    public String getMessage() {
        System.out.println("Your Message: " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
