package test.designpattern.singleton;

/**
 * 单例模式
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
