package test.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Callable Return Value Test
 */
public class PrimeThread {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
//        System.out.println("==" + service.submit(new TaskResult(66)).get().toString());
        service.execute(new TaskRun());
        System.out.println("Main thread");
    }
}

class TaskResult implements Callable<String> {

    private int id;

    public TaskResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result of TaskWithResult " + id;
    }
}

class TaskRun implements Runnable {
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable task");
    }
}
