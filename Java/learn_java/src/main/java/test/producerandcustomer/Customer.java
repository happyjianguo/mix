package test.producerandcustomer;

/**
 * 消费者
 */
public class Customer implements Runnable {
    private String name;
    private Channel channel;

    public Customer(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Good good = channel.get();
            if (good != null) {
                System.out.println(name + " 获得商品:" + good.getName());
            } else {
                synchronized (channel) {
                    try {
                        System.out.println(name + " 进入等待");
                        channel.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
