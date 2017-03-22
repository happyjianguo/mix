package test.springbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by joshua on 17/3/22.
 */
public class CustomerService implements InitializingBean, DisposableBean {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerService(String message) {
        this.message = message;
    }

    public void destroy() throws Exception {
        System.out.println("Spring Container is destory! Customer clean up");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method after properties are set: " + message);
    }
}
