/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.testaop;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: Chief.java, v 0.1 2018年04月26日 下午4:59 chuanshi.hzh Exp $
 */
public class Chief {

    @Value("chuanshi.hzh")
    private String name = "";

    private Oven oven;

    private Chief friend;

    public Chief getFriend() {
        return friend;
    }

    public void setFriend(Chief friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public Oven getOven() {
        return oven;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    public void userOven() {
        System.out.println(name + " use " + oven);
    }

}