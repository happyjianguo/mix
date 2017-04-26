package test.testguava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua on 17/4/26.
 */
public class CollectionDemo {

    public static void main(String[] args) {

        List<String> strList1 = new ArrayList<String>();
        strList1.add("a");
        strList1.add("b");
        strList1.add("c");
        strList1.add("d");

        // guava
        ImmutableList<String> strList2 = ImmutableList.of("a", "b", "c", "d");

        for (String str : strList1) {
            System.out.println(str);
        }
        for (String str : strList2) {
            System.out.println(str);
        }
    }
}
