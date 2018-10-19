package test.pipeline;

/**
 * 入口Handler
 *
 * @author chuanshi - 2018/10/19 15:57
 */
public interface InHandler extends Handler {

    public void response(AbstractContext ctx);

    public void register(AbstractContext ctx);

}
