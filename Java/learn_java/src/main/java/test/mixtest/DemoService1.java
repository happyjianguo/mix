/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: DemoService1.java, v 0.1 2018年04月26日 上午10:38 chuanshi.hzh Exp $
 */
@Service
public class DemoService1 {

    @Value("chuanshi.hzh")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}