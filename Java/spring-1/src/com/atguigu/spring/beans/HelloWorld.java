package com.atguigu.spring.beans;

import com.atguigu.spring.beans.test.Moveable;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

/**
 * Created by joshua on 16/5/28.
 */
public class HelloWorld {
    public static void main(String[] args) throws Exception{
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object o = f.getBean("v");
        Moveable m = (Moveable)o;
        m.run();
    }
}
