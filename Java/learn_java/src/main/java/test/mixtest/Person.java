package test.mixtest;

/**
 * Created by joshua on 17/3/14.
 */
public class Person implements IPerson {
    @Override
    public void run() {
        System.out.println("Person is running");
    }

    @Override
    public void talk() {
        System.out.println("Person is talking");
    }
}
