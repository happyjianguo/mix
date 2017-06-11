import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by chuanshi.hzh on 2017/6/4.
 *
 * @author chuanshi.hzh
 * @link http://blog.csdn.net/sdyy321/article/details/38757135/
 * @date 2017/06/04
 */
public class TestMockito {

    @Test
    public void testVerify() {

        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void when_thenReturn() {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        Assert.assertEquals("hello world world", result);
    }

}
