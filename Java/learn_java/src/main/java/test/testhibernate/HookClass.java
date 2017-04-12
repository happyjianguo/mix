package test.testhibernate;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Spring初始化回调
 * 实现InitializingBean接口
 */
@Component
public class HookClass implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring container init...");
    }
}
