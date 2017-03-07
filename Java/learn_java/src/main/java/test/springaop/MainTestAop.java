package test.springaop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring aop功能测试
 */

public class MainTestAop {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        personService.getNameById(1l);
        System.out.println("----------------------------------");
        personService.save("csy");
    }

}
