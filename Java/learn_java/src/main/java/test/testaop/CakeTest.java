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
 * @version $Id: CakeTest.java, v 0.1 2018年04月26日 下午4:53 chuanshi.hzh Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext-test.xml")
public class CakeTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testCake() {
        Cake cake = applicationContext.getBean(Cake.class);
        System.out.println(cake);
    }
}