package test.springdataredis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by joshua on 17/3/20.
 */
public class RedisTemplateTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-redis.xml");
        Order order = new Order("1", "222", 20.13, new Date(System.currentTimeMillis()));
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        // redis set
        orderDao.save(order);
        // redis get
        Order orderStore = orderDao.read("1");
        System.out.println(orderStore);
    }


}
