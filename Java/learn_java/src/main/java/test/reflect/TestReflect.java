package test.reflect;

import test.PrintTimeTask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java Reflect
 *
 * @see http://www.jb51.net/article/62070.htm
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

    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class<?> ownerClass = owner.getClass();
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Method method = ownerClass.getMethod(methodName, argsClass);
        return method.invoke(owner, args);
    }

//    public static void main(String[] args) throws Exception {
//        TestReflect testReflect = new TestReflect();
//        PrintTimeTask printTimeTask = new PrintTimeTask();
//        printTimeTask.setName("fanteathy");
//        System.out.println(testReflect.getProperty(printTimeTask, "name"));
//    }

//    public static void main(String[] args) throws Exception {
//        TestReflect testReflect = new TestReflect();
//        PrintTimeTask printTimeTask = new PrintTimeTask();
//        System.out.println(testReflect.getStaticProperty("test.PrintTimeTask", "testAttr"));
//    }

    public static void main(String[] args) throws Exception {
        TestReflect testReflect = new TestReflect();
        PrintTimeTask printTimeTask = new PrintTimeTask();
        testReflect.invokeMethod(printTimeTask, "printStr", new String[]{"invoke method"});
    }
}
