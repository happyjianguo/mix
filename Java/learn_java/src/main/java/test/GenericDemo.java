package test;

/**
 * 泛型测试
 *
 * @see http://www.weixueyuan.net/view/6321.html
 */
public class GenericDemo {
    public static void main(String[] args) {
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();

        System.out.println("The point is: " + x + ", " + y);
        p1.printPoint(x, y);

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();

        System.out.println("This point is：" + m + ", " + n);
        p2.printPoint(m, n);

        Info<String> obj = new InfoImp<String>("fanteathy");
        System.out.println("Length of String: " + obj.getVar().length());
    }
}

//定义泛型类
class Point<T1, T2> {
    T1 x;
    T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }

    // 定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y) {
        T1 m = x;
        T2 n = y;
        System.out.println("Point is: " + m + ", " + n);
    }
}

//定义泛型接口
interface Info<T> {
    public T getVar();
}

// 实现接口
class InfoImp<T> implements Info<T> {
    private T var;

    // 定义泛型构造方法
    public InfoImp(T var) {
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
}