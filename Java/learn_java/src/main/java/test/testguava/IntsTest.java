package test.testguava;

import com.google.common.primitives.Ints;

import java.util.List;

public class IntsTest {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> objArray = Ints.asList(intArray);
        System.out.println(objArray);
    }
}
