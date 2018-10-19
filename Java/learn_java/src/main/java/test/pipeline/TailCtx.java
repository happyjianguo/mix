package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 16:03
 */
public class TailCtx extends AbstractContext implements InHandler {

    public TailCtx(ChannelPipeLine pipeline) {
        super("Tail", pipeline, true, false);
    }


    @Override
    public Handler handler() {
        return this;
    }


    @Override
    public void response(AbstractContext ctx) {

        System.out.println("taill response is called !!!");
       /* ChannelPipeLine pipeline = getPipeline();
        pipeline.request();*/
    }


    @Override
    public void register(AbstractContext ctx) {
    }
}


