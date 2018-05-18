package test.mixtest;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap测试
 * <p>
 * 1. 并发写是线程安全的
 * 2. 写的时候，不能阻止读
 * 3. 想要写的时候阻止读，只有用synchronized锁定共享变量
 */
public class ConcurrentTest {

    private static final Logger logger = LoggerFactory.getLogger(ConcurrentTest.class);

    private static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();

    @Test
    public void testReadAndWrite() {

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {


            public void run() {

                synchronized (ConcurrentTest.hashMap) {
                    for (int i = 1; i < 1000; i++) {
                        ConcurrentTest.hashMap.put(String.valueOf(i), String.valueOf(i));
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }

            }
        });
        t1.start();

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (ConcurrentTest.hashMap) {
            String str = ConcurrentTest.hashMap.get("500");

//

            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
            System.out.println(ConcurrentTest.hashMap.size());
            Assert.assertEquals("500", str);
        }
    }
}
