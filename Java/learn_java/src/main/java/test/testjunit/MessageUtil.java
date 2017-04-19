package test.testjunit;

/**
 * Created by joshua on 17/4/19.
 */
public class MessageUtil {

    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String printMessage() {
        System.out.println(message);
        return message;
    }
}
