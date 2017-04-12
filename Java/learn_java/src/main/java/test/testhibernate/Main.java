package test.testhibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/4/12.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("testhibernate/applicationContext.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        Student student = new Student("joshua", 29);
        studentDao.save(student);
    }
}
