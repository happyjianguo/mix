package test.producerandcustomer;

import java.util.Random;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private static volatile int goodNumber = 0;

    private String name;
    private Channel channel;

    public Producer(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            int sleep = new Random().nextInt(2000);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Good good = new Good("商品-编号" + (++goodNumber));
            System.out.println(name + " 生产商品:" + good.getName());
            channel.put(good);
        }
    }
}
