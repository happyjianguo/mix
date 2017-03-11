package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by joshua on 17/3/11.
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("joshua");
        c.add(6);
        System.out.println("size of c: " + c.size());
        c.remove(6);
        System.out.println("size of c: " + c.size());
        System.out.println(c.contains("joshua"));

        Collection books = new HashSet();
        books.add("java");
        books.add("python");
        c.removeAll(books);
        books.retainAll(c);
        c.add("fanteathy");
        System.out.println(books);
        System.out.println(c);
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
