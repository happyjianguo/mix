package test.testserviceloader;

import java.util.ServiceLoader;

/**
 * Created by chuanshi.hzh on 2017/5/30.
 *
 * @author chuanshi.hzh
 * @date 2017/05/30
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<Command> serviceLoader = ServiceLoader.load(Command.class);
        for (Command command : serviceLoader) {
            command.execute();
        }
    }
}
