package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 16:11
 */
public class DefaultContext extends AbstractContext {

    private Handler handler;

    public DefaultContext(String name, ChannelPipeLine pipeline, Handler handler) {
        super(name, pipeline, isInbout(handler), isOutbound(handler));
        this.handler = handler;
    }


    @Override
    public Handler handler() {
        return handler;
    }

    private static boolean isInbout(Handler handler) {
        return handler instanceof InHandler;
    }

    private static boolean isOutbound(Handler handler) {
        return handler instanceof OutHandler;
    }
}


