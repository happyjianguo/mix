package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 15:59
 */
public interface OutHandler extends Handler {

    public void request(AbstractContext ctx);

}

