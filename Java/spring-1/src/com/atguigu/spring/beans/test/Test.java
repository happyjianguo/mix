package com.atguigu.spring.beans.test;

/**
 * Created by joshua on 16/6/4.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object o = f.getBean("v");
        Moveable m = (Moveable)o;
        m.run();
    }
}
