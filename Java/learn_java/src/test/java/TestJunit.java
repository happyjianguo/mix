import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {
    @Test
    public void testAdd() {
        String str = "Hello, world";
        assertEquals("Hello, world", str);
    }
}
