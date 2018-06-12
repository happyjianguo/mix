package test.testguava;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public class RangeTest {

    public static void main(String[] args) {
        Range<Integer> range = Range.openClosed(1, 10);
        for (int i : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.println(i);
        }
    }
}
