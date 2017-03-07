package test.springaop;

/**
 * 业务接口定义
 */
public interface PersonService {

    String getNameById(Long id);

    void save(String name);

    void update(String name, Long id);
}
