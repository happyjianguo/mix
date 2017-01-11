package test.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁redisson示例
 */
public class RedissonExample {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("localhost:6379").setConnectionPoolSize(10);
        RedissonClient redisson = Redisson.create(config);

        final CountDownLatch cdl = new CountDownLatch(10);
        long time = System.currentTimeMillis();
        final RLock rLock = redisson.getLock("hello-lock");
        final Map<String, Integer> map = new HashMap<String, Integer>(1);
        map.put("hello", 0);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    rLock.lock(10, TimeUnit.SECONDS);
                    map.put("hello", map.get("hello") + 1);
                    rLock.unlock();
                    cdl.countDown();
                }
            }).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result ->" + map.get("hello"));
        System.out.println(System.currentTimeMillis() - time);
    }
}
