package test.testspi;

import java.util.HashMap;

/**
 * Created by chuanshi.hzh on 2017/5/30.
 *
 * @author chuanshi.hzh
 * @date 2017/05/30
 */
public class Api {

    private static HashMap<String, Class<? extends Spi>> spis =
        new HashMap<String, Class<? extends Spi>>();
    private String protocol;

    public Api(String protocol) {
        this.protocol = protocol;
    }

    public void send(String msg) throws InstantiationException, IllegalAccessException {
        Spi spi = spis.get(protocol).newInstance();

        spi.send("Message begin");
        spi.send(msg);
        spi.send("Message end");
    }

    public static void register(String protocol, Class<? extends Spi> cls) {
        spis.put(protocol, cls);
    }
}
