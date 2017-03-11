package test;

/**
 * Created by joshua on 17/3/11.
 */
public class RuntimeTest {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        System.out.println("processor num: " + rt.availableProcessors());
        System.out.println("free memory: " + rt.freeMemory());
        System.out.println("total memory: " + rt.totalMemory());
        System.out.println("available memory: " + rt.maxMemory());
    }
}
