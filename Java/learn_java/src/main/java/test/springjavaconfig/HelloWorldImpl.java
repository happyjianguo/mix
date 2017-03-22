package test.springjavaconfig;

/**
 * Created by joshua on 17/3/22.
 */
public class HelloWorldImpl implements HelloWorld {

    public void printHelloWorld(String msg) {
        System.out.println("Hello : " + msg);
    }
}
