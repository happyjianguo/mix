package test.testguava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by joshua on 17/4/26.
 */
public class JoinerSplitterDemo {

    public static void main(String[] args) {

//        new JoinerSplitterDemo().splitTestOne();
//        new JoinerSplitterDemo().splitTestTwo();
//        new JoinerSplitterDemo().joinTestOne();
        new JoinerSplitterDemo().joinTestTwo();
    }

    public void splitTestOne() {
        String str = "test1, , test2, test3";
        Iterable<String> strArr = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(str);
        for (String strItem : strArr) {
            System.out.println(strItem);
        }
    }

    public void splitTestTwo() {
        String str = "key1: 1; key2: 2; key3: 3";
        Map<String, String> m = Splitter.on(';')
                .trimResults()
                .withKeyValueSeparator(':')
                .split(str);
        for (String key : m.keySet()) {
            System.out.println(String.format("key: %s, value: %s", key, m.get(key)));
        }
    }

    public void joinTestOne() {
        ArrayList<String> strArr1 = Lists.newArrayList("test1", "test2", null, "test3", "test4");
        System.out.println(Joiner.on(";").skipNulls().join(strArr1));
    }

    public void joinTestTwo() {
        Map<String, String> map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", null);
        map.put("key4", "value4");
        System.out.println(Joiner.on(";").useForNull("NULL").withKeyValueSeparator("=").join(map));
    }
}
