package test.testguava;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderingTest {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(3));
        numbers.add(new Integer(8));

        Ordering ordering = Ordering.natural();
        Collections.sort(numbers, ordering);
        System.out.println(numbers);
    }
}
