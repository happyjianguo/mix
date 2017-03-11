package test;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by joshua on 17/3/11.
 */
public class FileLockTest {

    public static void main(String[] args) throws Exception {

        try {
            FileChannel channel = new FileOutputStream("props.txt").getChannel();
            FileLock lock = channel.tryLock();
            Thread.sleep(1000);
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
