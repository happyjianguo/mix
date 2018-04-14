/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package test.mixtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author chuanshi.hzh
 * @version $Id: TestQueue.java, v 0.1 2018年04月14日 下午6:27 chuanshi.hzh Exp $
 */
public class TestQueue {

    public static <T> void printQueue(Queue<T> queue) {
        while (queue.peek() != null) {
            System.out.println(queue.poll() + " ");
        }
    }

    public static void main(String[] args) {

        Random random = new Random(47);
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            queue.offer(random.nextInt(20));
        }
        System.out.println(queue);
        printQueue(queue);
    }
}