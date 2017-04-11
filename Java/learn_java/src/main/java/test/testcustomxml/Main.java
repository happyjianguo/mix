package test.testcustomxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/4/11.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test_custom_xml.xml");
        Joshua j = (Joshua) ctx.getBean("js");
        System.out.println(j.getName());
    }
}
