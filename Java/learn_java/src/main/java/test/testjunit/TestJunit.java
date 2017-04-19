package test.testjunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joshua on 17/4/19.
 */
public class TestJunit {

    @Test
    public void testHello() {
        String str = "Hello, world";
        assertEquals("Hello, world", str);
    }
}
