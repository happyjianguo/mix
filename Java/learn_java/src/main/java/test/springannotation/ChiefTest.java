/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.springannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: ChiefTest.java, v 0.1 2018年04月26日 下午5:48 chuanshi.hzh Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext-test-2.xml")
public class ChiefTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testChief() {

        String aa = null;
        if(aa == null) {
            System.out.println("test");
        }

        Chief jack = (Chief) applicationContext.getBean(Chief.class);
        Cake cake = applicationContext.getBean(Cake.class);
        cake.setName("blueberryCheeseCake");
        jack.makeOneCake(cake);
    }
}