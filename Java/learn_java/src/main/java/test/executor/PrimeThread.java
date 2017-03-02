package test.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Callable Future
 */
public class PrimeThread {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("==" + service.submit(new TaskResult(66)).get().toString());
    }
}

class TaskResult implements Callable<String> {

    private int id;

    public TaskResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
