package test.executor;

import java.util.concurrent.Callable;

/**
 * Created by joshua on 17/3/2.
 */
public class CallableClass implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Callable";
    }
}
