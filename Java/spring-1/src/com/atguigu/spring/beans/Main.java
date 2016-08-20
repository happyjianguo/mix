package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joshua on 16/5/28.
 */
public class Main {

    public static void main(String[] args){

        /*
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("atguigu");
        */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.print(dataSource);
    }
}
