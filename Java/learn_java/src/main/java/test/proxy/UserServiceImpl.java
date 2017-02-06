package test.proxy;

/**
 * Service Definition
 */
public class UserServiceImpl implements UserService {

    public String getName(int id) {
        System.out.println("----------getName----------");
        return "Joshua";
    }

    public Integer getAge(int id) {
        System.out.println("----------getAge----------");
        return 28;
    }
}
