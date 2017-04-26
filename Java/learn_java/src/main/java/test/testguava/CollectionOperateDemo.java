package test.testguava;

import com.google.common.collect.Sets;

import java.util.HashSet;

import static com.google.common.collect.Sets.SetView;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Google Collections
 */
public class CollectionOperateDemo {

    public static void main(String[] args) {
        new CollectionOperateDemo().setDemo();
    }

    // set交，差，并集运算
    public void setDemo() {
        HashSet setA = newHashSet(1, 2, 3, 4, 5);
        HashSet setB = newHashSet(4, 5, 6, 7, 8);

        SetView union = Sets.union(setA, setB);
        System.out.println("Union: ");
        for (Object num : union) {
            System.out.println(num);
        }

        SetView difference = Sets.difference(setA, setB);
        System.out.println("difference:");
        for (Object integer : difference)
            System.out.println(integer);

        SetView intersection = Sets.intersection(setA, setB);
        System.out.println("intersection:");
        for (Object integer : intersection)
            System.out.println(integer);
    }
}
