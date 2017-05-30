package test.testspi;

/**
 * Created by chuanshi.hzh on 2017/5/30.
 *
 * @author chuanshi.hzh
 * @date 2017/05/30
 */
public class Program {

    public static void main(String[] args) throws InstantiationException,
        IllegalAccessException, ClassNotFoundException {
        Class.forName("test.testspi.SpiA");

        Api api = new Api("a");
        api.send("chuanshi.hzh");
    }
}
