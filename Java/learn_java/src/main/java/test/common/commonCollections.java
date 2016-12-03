package test.common;

import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.map.LinkedMap;

/**
 * Created by joshua on 16/12/3.
 */
public class commonCollections {

    public static void main(String[] args) {
        OrderedMap map = new LinkedMap();
        map.put("FIVE", "5");
        map.put("SIX", "6");
        map.firstKey();
        String str = (String) map.nextKey("FIVE");
        System.out.println(str);
    }
}
