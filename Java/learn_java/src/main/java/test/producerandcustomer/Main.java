package test.producerandcustomer;


/**
 * 生产者/消费者Demo
 * notify/notifyAll
 * http://www.cnblogs.com/taoweiji/p/5188514.html
 */
public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel();
        new Thread(new Producer("生产者1", channel)).start();
        new Thread(new Producer("生产者2", channel)).start();
        new Thread(new Producer("生产者2", channel)).start();

        new Thread(new Customer("消费者1", channel)).start();
        new Thread(new Customer("消费者2", channel)).start();
        new Thread(new Customer("消费者3", channel)).start();
    }
}
