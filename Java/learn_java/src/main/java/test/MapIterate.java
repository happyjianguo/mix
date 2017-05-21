package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map遍历的方式
 *
 * @author chuanshi.hzh
 * @date 2017/05/21
 */
public class MapIterate {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 2);
        map.put(3, 4);

        System.out.println(map.entrySet());
        // method 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // method 2
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        // method 3
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
