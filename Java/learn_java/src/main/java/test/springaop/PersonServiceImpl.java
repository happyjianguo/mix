package test.springaop;

/**
 * 业务接口实现
 */
public class PersonServiceImpl implements PersonService {

    public String getNameById(Long id) {
        System.out.println("我是getNameById()方法");
        return "csy";
    }

    public void save(String name) {
//        throw new RuntimeException("故意抛出了异常,仅供测试");
        System.out.println("我是save()方法");
    }

    public void update(String name, Long id) {
        System.out.println("我是update()方法");
    }

}
