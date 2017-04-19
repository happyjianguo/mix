package test.testmybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by joshua on 17/4/19.
 */
public class MybatisSpringTest {

    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("testmybatis/applicationContext.xml");
    }

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        UserModel user = userMapper.selectUserByID(1);
        System.out.println(user.getUserAddress());

        List<Article> articles = userMapper.getUserArticles(1);
        for (Article article : articles) {
            System.out.println(article.getContent());
        }
    }
}
