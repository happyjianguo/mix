package test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by joshua on 16/12/10.
 */
public class PrintTimeTask extends TimerTask {

    public static final String testAttr = "hello,world";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public static void testMethod() {
        System.out.println("test");
    }

    public void run() {
        System.out.println(new Date().toString());
    }

    public static void main(String[] args) {
        Timer timer = new Timer("hello");
        timer.schedule(new PrintTimeTask(), 1000L, 2000L);
    }
}
