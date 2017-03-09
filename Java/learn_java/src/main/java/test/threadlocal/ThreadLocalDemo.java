package test.threadlocal;

import java.util.Random;

/**
 * 多线程客户端程序,用于测试
 *
 * @link http://www.cnblogs.com/vigarbuaa/archive/2012/03/01/2375149.html
 */
public class ThreadLocalDemo extends Thread {

    public static void main(String[] args) {
        Thread threadOne = new ThreadLocalDemo();
        threadOne.start();
        Thread threadTwo = new ThreadLocalDemo();
        threadTwo.start();
    }

    @Override
    public void run() {

        Context context = new Context();
        Random random = new Random();
        int age = random.nextInt(100);
        context.setTransactionId(String.valueOf(age));

        System.out.println("set thread [" + getName() + "] contextid to " + String.valueOf(age));

        // 在ThreadLocal中设置context
        MyThreadLocal.set(context);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new BusinessService().businessMethod();
        MyThreadLocal.unset();
    }
}
