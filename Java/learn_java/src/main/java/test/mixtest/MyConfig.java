/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: MyConfig.java, v 0.1 2018年04月26日 上午10:59 chuanshi.hzh Exp $
 */
@Configuration
@ComponentScan("test.mixtest")
public class MyConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        ELConfig config = context.getBean(ELConfig.class);
        config.output();
        context.close();
    }
}