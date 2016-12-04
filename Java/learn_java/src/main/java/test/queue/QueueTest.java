package test.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by joshua on 16/12/4.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        for (String q : queue) {
            System.out.println(q);
        }
        String poll = queue.poll();
        System.out.println("pool = " + poll);
        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println(queue.peek());
    }
}
