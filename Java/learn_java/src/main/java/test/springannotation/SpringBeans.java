/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.springannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: SpringBeans.java, v 0.1 2018年04月26日 下午5:46 chuanshi.hzh Exp $
 */
@Configuration
public class SpringBeans {
    @Bean
    public Chief jack() {
        Chief chief = new Chief();
        chief.setName("jack");
        chief.setOven(oven());
        chief.setCake(cake());
        return chief;
    }

    @Bean
    public Oven oven() {
        Oven oven = new Oven();
        oven.setName("big oven");
        return oven;
    }

    @Bean
    public Cake cake() {
        Cake cake = new Cake();
        cake.setName("blueberryCheeseCake");
        return cake;
    }

    @Bean
    public Log log() {
        return new Log();
    }

}