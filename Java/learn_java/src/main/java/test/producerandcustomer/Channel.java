package test.producerandcustomer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 消费通道
 */
public class Channel {
    private Queue<Good> goodList = new LinkedList<Good>();

    public synchronized Good get() {
        if (goodList.size() == 0) {
            return null;
        }
        Good good = goodList.remove();
        return good;
    }

    public synchronized void put(Good good) {
        goodList.add(good);
//        notifyAll();
        notify();
    }
}
