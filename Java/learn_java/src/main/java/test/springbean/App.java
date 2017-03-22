package test.springbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by joshua on 17/3/22.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // http://stackoverflow.com/questions/14423980/how-to-close-a-spring-applicationcontext
        ((ConfigurableApplicationContext) context).close();
    }
}
