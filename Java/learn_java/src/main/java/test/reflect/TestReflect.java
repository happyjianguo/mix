package test.reflect;

import test.PrintTimeTask;

import java.lang.reflect.Field;

/**
 * Created by joshua on 17/1/9.
 */
public class TestReflect {

    public Object getProperty(Object owner, String fieldName) throws Exception {
        Class<?> ownerClass = owner.getClass();
        Field field = ownerClass.getField(fieldName);
        Object property = field.get(owner);
        return property;
    }

    public Object getStaticProperty(String className, String fieldName) throws Exception {
        Class<?> ownerClass = Class.forName(className);
        Field field = ownerClass.getField(fieldName);
        Object property = field.get(ownerClass);
        return property;
    }

//    public static void main(String[] args) throws Exception {
//        TestReflect testReflect = new TestReflect();
//        PrintTimeTask printTimeTask = new PrintTimeTask();
//        printTimeTask.setName("fanteathy");
//        System.out.println(testReflect.getProperty(printTimeTask, "name"));
//    }

    public static void main(String[] args) throws Exception {
        TestReflect testReflect = new TestReflect();
        PrintTimeTask printTimeTask = new PrintTimeTask();
        System.out.println(testReflect.getStaticProperty("test.PrintTimeTask", "testAttr"));
    }
}
