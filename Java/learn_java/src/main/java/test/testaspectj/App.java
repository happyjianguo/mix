package test.testaspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/3/23.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("testaspectj.xml");
        CustomerBo customerBo = (CustomerBo) context.getBean("customerBo");
        customerBo.addCustomer();
    }
}
