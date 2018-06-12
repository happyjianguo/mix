package test.testguava;

import com.google.common.base.Throwables;

public class ThrowablesTest {

    public static void main(String[] args) {
        try {
            System.out.println(Math.sqrt(-3));
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e);
        }
    }
}
