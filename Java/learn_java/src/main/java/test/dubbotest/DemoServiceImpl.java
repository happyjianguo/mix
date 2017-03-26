package test.dubbotest;

/**
 * Created by joshua on 17/3/26.
 */
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public User findUserById(long id) {
        User user = new User();
        user.setId(id);
        user.setName("Joshua");
        user.setAge(29);

        return user;
    }
}
