package com.atguigu.spring.beans.test;

/**
 * Created by joshua on 16/6/4.
 */
public class Train implements Moveable {
    @Override
    public void run() {
        System.out.println("呜呜呜~~，只能挤火车 ~~~");
    }
}
