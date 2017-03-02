package test.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Test about future
 */
public class CallableRunnableTest {

    public static void main(String[] args) {
//        Thread runnable = new Thread(new RunnableClass());
//        runnable.start();

        Callable<String> callable = new CallableClass();
        FutureTask<String> future = new FutureTask<String>(callable);
        Thread t = new Thread(future);
        t.start();
        while (true) {
            System.out.println("waiting for future");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (future.isDone()) {
                try {
                    String strVal = future.get();
                    System.out.println("Future done");
                    System.out.println(strVal);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Main thread finished");
    }
}
