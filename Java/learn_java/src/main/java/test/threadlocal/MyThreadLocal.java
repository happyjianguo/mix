package test.threadlocal;

/**
 * 创建MyThreadLocal做为容器，将一个Context对象保存于ThreadLocal中
 */
public class MyThreadLocal {

    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static void set(Context user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Context get() {
        return (Context) userThreadLocal.get();
    }
}
