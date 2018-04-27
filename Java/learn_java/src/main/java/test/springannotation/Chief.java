/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.springannotation;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Chief.java, v 0.1 2018年04月26日 下午5:44 chuanshi.hzh Exp $
 */
public class Chief {

    private static int index = 0;
    private final int id = index++;
    private Cake cake = null;
    private String name = "";
    private Oven oven = null;

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Chief.index = index;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Oven getOven() {
        return oven;
    }

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    public void makeOneCake(Cake cake) {
        System.out.println(getName() + " make " + cake.getName());
    }

}