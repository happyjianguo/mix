package test.testguava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetTest {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        multiset.add("c");

        for (String s : multiset) {
            System.out.println(s);
        }
    }
}
