package test;

import java.sql.Timestamp;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 高并发场景下System.currentTimeMillis()的性能问题的优化
 * see: https://www.cnblogs.com/nyvi/p/8837012.html
 *
 * @author chuanshi - 2018/10/25 21:36
 */
public class SystemClock {

    private final long period;

    private final AtomicLong now;

    private SystemClock(long period) {
        this.period = period;
        this.now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    private static SystemClock instance() {
        return InstanceHolder.INSTANCE;
    }

    public static long now() {
        return instance().currentTimeMillis();
    }

    public static String nowDate() {
        return new Timestamp(instance().currentTimeMillis()).toString();
    }

    private void scheduleClockUpdating() {

        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "System Clock");
                thread.setDaemon(true);
                return thread;
            }
        });

        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                now.set(System.currentTimeMillis());
            }
        }, period, period, TimeUnit.MILLISECONDS);
    }

    private long currentTimeMillis() {
        return now.get();
    }

    private static class InstanceHolder {
        public static final SystemClock INSTANCE = new SystemClock(1);
    }

    // 性能测试
    public static void main(String[] args) {

        long timeStart1 = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            long nowTime = SystemClock.now();
        }
        long timeEnd1 = System.currentTimeMillis();
        System.out.println("SystemClock.now() cost: " + (timeEnd1 - timeStart1) + "ms");

        long timeStart2 = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            long nowTime = System.currentTimeMillis();
        }
        long timeEnd2 = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis() cost: " + (timeEnd2 - timeStart2) + "ms");
    }
}
