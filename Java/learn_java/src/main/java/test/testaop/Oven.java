/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Oven.java, v 0.1 2018年04月26日 下午4:58 chuanshi.hzh Exp $
 */
public class Oven {
    private String name = "";

    private double size = 0;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

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