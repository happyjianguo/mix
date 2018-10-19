package test.pipeline;

/**
 * @author chuanshi - 2018/10/19 15:43
 */
public abstract class AbstractContext implements Context {

    volatile AbstractContext next;
    volatile AbstractContext prev;

    private final boolean inbound;
    private final boolean outbound;
    private final ChannelPipeLine pipeline;
    private final String name;


    public AbstractContext(String name, ChannelPipeLine pipeline, boolean inbound, boolean outbound) {
        this.inbound = inbound;
        this.outbound = outbound;
        this.name = name;
        this.pipeline = pipeline;
    }

    public ChannelPipeLine pipeline() {
        return pipeline;
    }

    public Channel channel() {
        return pipeline.channel();
    }

    public String getName() {
        return name;
    }


    private AbstractContext findContextInbound() {
        AbstractContext ctx = this;
        do {
            ctx = ctx.next;
        } while (!ctx.inbound);
        return ctx;
    }

    private AbstractContext findContextOutbound() {
        AbstractContext ctx = this;
        do {
            ctx = ctx.prev;
        } while (!ctx.outbound);
        return ctx;
    }


    public void request() {
        final AbstractContext next = findContextOutbound();
        next.invokeRequest();
    }


    private void invokeRequest() {
        OutHandler outhandler = (OutHandler) handler();
        outhandler.request(this);
    }


    public void response() {
        final AbstractContext next = findContextInbound();
        next.invokeResponse();

    }


    private void invokeResponse() {
        InHandler inhandler = (InHandler) handler();
        inhandler.response(this);
    }

    public void register() {
        AbstractContext contextInbound = findContextInbound();
        contextInbound.invokeRegister();

    }

    private void invokeRegister() {
        InHandler inhandler = (InHandler) handler();
        inhandler.register(this);

    }

}


