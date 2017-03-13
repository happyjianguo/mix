package test;

import org.apache.commons.collections.map.HashedMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * 对象工厂，spring核心
 */
public class ObjectPoolFactory {

    private Map<String, Object> objectPool = new HashedMap();

    private Object createObject(String clazzName) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }

    public void initPool(String fileName) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Properties props = new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()) {
                objectPool.put(name, createObject(props.getProperty(name)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) throws Exception {
        ObjectPoolFactory pf = new ObjectPoolFactory();
        pf.initPool("obj.txt");
        System.out.println(pf.getObject("a"));
    }
}
