/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

import org.aspectj.lang.JoinPoint;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Log.java, v 0.1 2018年04月26日 下午4:03 chuanshi.hzh Exp $
 */
public class Log {

    public void before() {
        System.out.println("before login");
    }

    public void after(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        for (int i = 0; i < objects.length; i++) {
            User user = (User) objects[i];
            System.out.println("save login log:" + user.getName() + " login");
        }
    }
}