package test;

/**
 * GC Test
 */
public class GcTest {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            new GcTest();
            // GC
//             System.gc();
            Runtime.getRuntime().gc();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Cleaning resources of GcTest");
    }
}
