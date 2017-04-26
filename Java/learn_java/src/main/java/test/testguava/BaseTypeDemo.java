package test.testguava;

import com.google.common.primitives.Ints;

/**
 * Created by joshua on 17/4/26.
 */
public class BaseTypeDemo {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int a = 4;
        System.out.println(String.valueOf(Ints.contains(array, a)));
    }
}
