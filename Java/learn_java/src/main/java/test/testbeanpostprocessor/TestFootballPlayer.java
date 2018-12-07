package test.testbeanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chuanshi - 2018-12-07 13:53
 */
public class TestFootballPlayer {

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("testbeanpostprocessor.xml");
        FootballPlayer smone = ctx.getBean("cluo", FootballPlayer.class);
        smone.shoot();
        smone.pass();
    }
}
