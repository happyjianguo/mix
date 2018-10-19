package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 16:00
 */
public class HeadCtx extends AbstractContext implements OutHandler {

    public HeadCtx(ChannelPipeLine pipeline) {
        super("Head", pipeline, false, true);
    }

    @Override
    public Handler handler() {
        return this;
    }


    @Override
    public void request(AbstractContext ctx) {
        System.out.println("head connect method is called!!!");
       /* ChannelPipeLine pipeLine = getPipeline();
        pipeLine.response();*/
    }


    public void fireRegister() {
    }
}


