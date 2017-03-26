package test.dubbotest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/3/26.
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "dubbotest/consumer.xml"
        );
        context.start();


        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("Joshua");
        System.out.println(hello);


        User user = demoService.findUserById(88);
        System.out.println(user);
    }
}
