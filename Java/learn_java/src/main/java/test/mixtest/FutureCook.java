/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: FutureCook.java, v 0.1 2018年04月13日 下午2:24 chuanshi.hzh Exp $
 */
public class FutureCook {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();
        Callable<Chuju> onlineShopping = new Callable<Chuju>() {
            public Chuju call() throws Exception {

                System.out.println("第一步: 下单");
                System.out.println("第一步: 等待收货");
                System.out.println("第一步: 快递送到");
                Thread.sleep(9000);
                return new Chuju();
            }
        };

        FutureTask<Chuju> task = new FutureTask<Chuju>(onlineShopping);
        new Thread(task).start();

        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步: 食材到位");

        if (!task.isDone()) {
            System.out.println("第三步: 厨具还未到");
        }

        Chuju chuju = task.get();
        System.out.println("第三步: 厨具到位，开始展现厨艺");
        cook(chuju, shicai);
        System.out.println("总共用时: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    static void cook(Chuju chuju, Shicai shicai) {

    }

    static class Chuju {}

    ;

    static class Shicai {}

    ;
}