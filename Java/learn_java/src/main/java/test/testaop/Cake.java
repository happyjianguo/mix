/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Cake.java, v 0.1 2018年04月26日 下午4:52 chuanshi.hzh Exp $
 */
public class Cake {

    private int id = 0;

    private String name = "";

    private double size = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "cake id:" + id + " name:" + name + " size:" + size;
    }

}