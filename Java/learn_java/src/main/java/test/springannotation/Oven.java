/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.springannotation;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Oven.java, v 0.1 2018年04月26日 下午6:05 chuanshi.hzh Exp $
 */
public class Oven {
    private String name = "";

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
