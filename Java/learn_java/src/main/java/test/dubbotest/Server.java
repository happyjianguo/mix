package test.dubbotest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by joshua on 17/3/26.
 */
public class Server {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "dubbotest/provider.xml");
        context.start();
        System.out.println("Dubbo provider start...");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
