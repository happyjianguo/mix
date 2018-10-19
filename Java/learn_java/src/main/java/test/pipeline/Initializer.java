package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 16:17
 */
public abstract class Initializer implements InHandler {

    private String name = "initializer";

    @Override
    public void response(AbstractContext ctx) {
    }


    @Override
    public void register(AbstractContext ctx) {
        initChannel(ctx);
        ctx.register();
    }


    private void initChannel(AbstractContext ctx) {
        try {
            Channel channel = ctx.channel();
            initChannel(channel);
        } finally {
            remove(ctx);
        }
    }


    public abstract void initChannel(Channel channel);


    private void remove(AbstractContext ctx) {
        ChannelPipeLine pipeline = ctx.pipeline();
        if (pipeline.context(this) != null) {
            pipeline.remove(this);
        }
    }
}

