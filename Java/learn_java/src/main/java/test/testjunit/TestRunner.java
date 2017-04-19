package test.testjunit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by joshua on 17/4/19.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestMessageUtil.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
