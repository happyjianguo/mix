/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: LoginServiceImpl.java, v 0.1 2018年04月26日 下午4:02 chuanshi.hzh Exp $
 */
public class LoginServiceImpl {

    public void login(User user) {
        if (user != null) {
            System.out.println(user.getName() + " login");
        }
    }
}