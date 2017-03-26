package test.dubbotest;

/**
 * Created by joshua on 17/3/26.
 */
public interface DemoService {

    String sayHello(String name);

    User findUserById(long id);
}
