package test.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// invokeAll方法测试
public class InvokeAllTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 放多个callable任务
        List<Callable<String>> callableList = new ArrayList<Callable<String>>();
        callableList.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(3000);
                throw new IllegalAccessException();
            }
        });
        callableList.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(3000);
                return "ok";
            }
        });
        // 调用invoke方法,executorService.invokeAll(tasks)方法底层的做法是如果future.isDone是false,那么future.get()一直等待.
        // 如果需要控制超时时间,可以调用invokeAll(tasks,timeout,unit)方法,
        // 底层做法是如果future.isDone是false,那么future.get(timeout,unit),等待指定时间——所有task共用timeout的时间
        // 问题: 既然调用了invokeAll方法, 只有所有任务执行完成之后才会返回.那么为什么返回的是Future对象,而不是直接的目标对象呢.
        // 因为"任务执行完成"的情况正常调用结束,或者抛异常,或者被cancel. 如果直接返回目标对象,那么没法处理异常的情况
        List<Future<String>> result = executorService.invokeAll(callableList);
        // 输出cost step 1:6015
        System.out.println("cost step 1:" + (System.currentTimeMillis() - start));
        for (Future<String> future : result) {
            if (future.isDone() && !future.isCancelled()) {
                try {
                    // 输出ok. 因为任务已经执行完成了,所以直接get就行,不用设置超时时间.
                    System.out.println(future.get());
                } catch (ExecutionException e) {
                    // 输出java.lang.IllegalAccessException——抛得到异常也是执行完成.
                    // 如果invokeAll不返回futrue对象,而是直接返回String对象,则没法处理这种情况
                    System.out.println(e.getMessage());
                }
            }
        }
        // 输出cost step 1:6016
        System.out.println("cost step 2:" + (System.currentTimeMillis() - start));
    }
}
