package test.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by joshua on 17/3/22.
 */
@Configuration
public class SpringConfig {

    @Bean(name = "customerService")
    public CustomerService customerService() {
        return new CustomerService("hello, world");
    }
}
