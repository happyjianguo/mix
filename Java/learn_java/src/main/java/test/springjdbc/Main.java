package test.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/3/22.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("springjdbc.xml");
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDAO");
        Customer customer = new Customer(1, "Joshua", 29);
        customerDao.insert(customer);

        Customer customer1 = customerDao.findByCustomerId(1);
        System.out.println(customer1);
    }
}
