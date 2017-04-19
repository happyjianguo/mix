package test.testjunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joshua on 17/4/19.
 */
public class TestMessageUtil {

    String message = "Hello world";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "New World";
        assertEquals(message, messageUtil.printMessage());
    }
}
