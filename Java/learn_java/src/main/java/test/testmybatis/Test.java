package test.testmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by joshua on 17/4/18.
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("testmybatis/configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {

        //select
        Test test = new Test();
        test.getUserList("joshua");

        // add
//        test.addUser();
    }

    // select
    public void getUserList(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<UserModel> users = userMapper.selectUsers(userName);
            for (UserModel user : users) {
                System.out.println(user.getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    // add
    public void addUser() {
        UserModel user = new UserModel();
        user.setUserName("fanteathy");
        user.setUserAge("29");
        user.setUserAddress("Jiading");

        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.addUser(user);
            session.commit();
            System.out.println("The inserted user id is " + user.getId());
        } finally {
            session.close();
        }

    }
}
