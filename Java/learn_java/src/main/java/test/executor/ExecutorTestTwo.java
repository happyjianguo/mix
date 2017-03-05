package test.executor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * ExecutorService invokeAll
 */
public class ExecutorTestTwo {

    public static void main(String[] args) {

        long timeNow = System.currentTimeMillis();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(4000);
                return "Task 1";
            }
        });

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Task 2";
            }
        });

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(10000);
                return "Task 3";
            }
        });

        /**
         * invokeAny 4s
         */
//        try {
//            String result = executorService.invokeAny(callables);
//            long timeEnd = System.currentTimeMillis();
//            System.out.println("result = " + result);
//            System.out.println("time cost " + (timeEnd - timeNow));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
        /**
         * invokeAll 16s
         */
//        try {
//            List<Future<String>> result = executorService.invokeAll(callables);
//            for (Future<String> res : result) {
//                try {
//                    System.out.println(res.get());
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//            long timeEnd = System.currentTimeMillis();
//            System.out.println("result = " + result);
//            System.out.println("time cost " + (timeEnd - timeNow));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /**
         * submit 16s
         */
        for (Callable<String> callable : callables) {
            Future<String> result = executorService.submit(callable);
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("time cost " + (timeEnd - timeNow));
    }
}
