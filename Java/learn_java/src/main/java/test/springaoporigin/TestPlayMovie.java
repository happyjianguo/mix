package test.springaoporigin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 17/3/26.
 */
public class TestPlayMovie {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springaoporigin.xml"
        );
        Movie movie = (Movie) context.getBean("movie");
        try {
            movie.playMovie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
