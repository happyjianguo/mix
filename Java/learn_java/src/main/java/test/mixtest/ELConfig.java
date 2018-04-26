/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: ELConfig.java, v 0.1 2018年04月26日 上午10:39 chuanshi.hzh Exp $
 */
@Configuration
@ComponentScan("test.mixtest")
@PropertySource(value = "classpath:t.properties")
public class ELConfig {

    @Value("I Love You!")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("${joshua.username}")
    private String nickname;

    public void output() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(nickname);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}