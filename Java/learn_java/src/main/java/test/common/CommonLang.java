package test.common;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joshua on 16/12/3.
 * from: http://rensanning.iteye.com/blog/1547845
 */
public class CommonLang {

    public static void main(String[] args) {
//        System.out.println(StringUtils.isEmpty("fanteathy"));
//        System.out.println(StringUtils.trim(" fanteathy "));
//        String str2 = "aaa,bbb,ccc";
//        String[] strArr = StringUtils.split(str2, ",");
//        for(String str:strArr){
//            System.out.println(str);
//        }
//        String[] arr = {"aaa", "bbb", "ccc"};
//        String result = StringUtils.join(arr, ",");
//        System.out.println(result);
//        String[] array5 = {"aaa", "bbb", "ccc", "ddd"};
//        boolean result1 = ArrayUtils.contains(array5, "bbb");
//        System.out.println(result1);
//        try{
//            Date date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});
//            Date tenDayAfter = DateUtils.addDays(date, 10);
//            System.out.println(DateFormatUtils.format(tenDayAfter, "yyyy/MM/dd HH:mm:ss"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        SampleBean bean1 = new SampleBean();
        bean1.setName("fanteathy");
        bean1.setAge(31);


        try {
            String name1 = BeanUtils.getProperty(bean1, "name");
            System.out.println(name1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        SampleBean bean2 = new SampleBean();
        try {
            BeanUtils.setProperty(bean2, "name", "joshua");
            System.out.println(bean2.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        SampleBean bean4 = new SampleBean();
        bean4.setName("Joshua");
        bean4.setAge(28);

        try {
            Map<String, String> map4 = BeanUtils.describe(bean4);
            System.out.println(map4.get("name"));
            System.out.println(map4.get("age"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        SampleBean bean5 = new SampleBean();
        Map<String, String> map5 = new HashMap<String, String>();
        map5.put("name", "test");
        map5.put("age", "120");

        try {
            BeanUtils.populate(bean5, map5);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(bean5.getName());

    }
}
