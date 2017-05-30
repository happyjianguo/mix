package test.testserviceloader;

/**
 * Created by chuanshi.hzh on 2017/5/30.
 *
 * @author chuanshi.hzh
 * @date 2017/05/30
 */
public class ShutdownCommand implements Command {

    public void execute() {
        System.out.println("shutdown");
    }
}
