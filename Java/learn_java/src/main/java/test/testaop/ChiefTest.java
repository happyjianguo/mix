/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: ChiefTest.java, v 0.1 2018年04月26日 下午5:00 chuanshi.hzh Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext-test.xml")
public class ChiefTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testChief() {
        Chief jack = (Chief) applicationContext.getBean("jack");
        jack.userOven();
        Chief rose = (Chief) applicationContext.getBean("rose");
        rose.userOven();
        Chief mike = (Chief) applicationContext.getBean("mike");
        mike.userOven();
        Chief dick = (Chief) applicationContext.getBean("dick");
        dick.userOven();
        System.out.println("chief name:" + jack.getName());
    }
}