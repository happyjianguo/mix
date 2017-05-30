package test.testspi;

/**
 * Created by chuanshi.hzh on 2017/5/30.
 *
 * @author chuanshi.hzh
 * @date 2017/05/30
 */
public class SpiA implements Spi {

    static {
        Api.register("a", SpiA.class);
    }

    public void send(String msg) {
        System.out.println("SpiA: " + msg);
    }
}
