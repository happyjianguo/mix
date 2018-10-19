package test.pipeline;

/**
 * 一个Channel包含一个ChannelPipeline，
 * 所有ChannelHandler都会注册到ChannelPipeline中，并按顺序组织起来。
 *
 * @author chuanshi - 2018/10/19 15:46
 */
public class Channel {

    private ChannelPipeLine pipeLine;

    public Channel() {
        this.pipeLine = new ChannelPipeLine(this);
    }

    public ChannelPipeLine pipeLine() {
        return this.pipeLine;
    }

    public static void main(String[] args) {
        Handler inHandler1 = new InHandler() {
            private String name = "InHandler1";

            @Override
            public void response(AbstractContext ctx) {
                System.out.println("InHandler1 response called !!!");
                ctx.response();
            }

            @Override
            public void register(AbstractContext ctx) {
                System.out.println("inHandler 1 register called !!!");
                ctx.register();

            }
        };

        Handler outHandler1 = new OutHandler() {
            private String name = "OutHandler1";

            @Override
            public void request(AbstractContext ctx) {
                System.out.println("OutHandler1 connect called !!!");
                ctx.request();
            }
        };

        Handler inHandler2 = new InHandler() {
            private String name = "InHandler2";

            @Override
            public void response(AbstractContext ctx) {
                System.out.println("InHandler2 response called !!!");
                ctx.response();
            }

            @Override
            public void register(AbstractContext ctx) {
                System.out.println("inHandler 2 register called !!!");
                ctx.register();
            }
        };

        Handler outHandler2 = new OutHandler() {
            private String name = "OutHandler2";

            @Override
            public void request(AbstractContext ctx) {
                System.out.println("OutHandler2 connect called !!!");
                ctx.request();
            }
        };

        Channel channel = new Channel();
        ChannelPipeLine pipeLine = channel.pipeLine();
        pipeLine.addLast(new Initializer() {
            @Override
            public void initChannel(Channel channel) {
                ChannelPipeLine pipeLine = channel.pipeLine();
                pipeLine.addLast(inHandler1);
                pipeLine.addLast(outHandler1);
                pipeLine.addLast(inHandler2);
                pipeLine.addLast(outHandler2);
            }
        });


        pipeLine.register();

        System.out.println("add done !!!");
        System.out.println();

        System.out.println("out bount event start !!!");
        pipeLine.request();
        System.out.println();


        System.out.println("in bount event start !!!");
        pipeLine.response();
    }


}

