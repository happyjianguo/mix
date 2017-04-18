package test.mixtest;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joshua on 17/4/18.
 */
public class CollectionTest {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        System.out.println("list size: " + list.size());
        System.out.println("Type of Class: " + list.get(0).getClass().getName());
        for (Object a : list) {
            System.out.println(a);
        }
    }
}
