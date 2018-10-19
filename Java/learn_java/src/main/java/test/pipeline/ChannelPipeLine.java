package test.pipeline;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chuanshi - 2018/10/19 15:45
 */

public class ChannelPipeLine {


    private Channel channel;
    final AbstractContext head;
    final AbstractContext tail;
    final AtomicInteger inCounter = new AtomicInteger(0);
    final AtomicInteger outCounter = new AtomicInteger(0);


    public ChannelPipeLine(Channel channel) {

        this.channel = channel;
        head = new HeadCtx(this);
        tail = new TailCtx(this);

        head.next = tail;
        tail.prev = head;
    }

    public Channel channel() {
        return channel;
    }


    public final AbstractContext context(Handler handler) {
        if (handler == null) {
            throw new NullPointerException("handler");
        }

        AbstractContext ctx = head.next;
        for (; ; ) {

            if (ctx == null) {
                return null;
            }

            if (ctx.handler() == handler) {
                return ctx;
            }

            ctx = ctx.next;
        }
    }


    public final ChannelPipeLine remove(Handler handler) {
        remove(getContextOrDie(handler));
        return this;
    }

    private AbstractContext getContextOrDie(Handler handler) {
        AbstractContext ctx = context(handler);
        if (ctx == null) {
            throw new NoSuchElementException(handler.getClass().getName());
        } else {
            return ctx;
        }
    }


    private AbstractContext remove(final AbstractContext ctx) {
        assert ctx != head && ctx != tail;

        synchronized (this) {
            remove0(ctx);
        }
        return ctx;
    }

    private static void remove0(AbstractContext ctx) {
        AbstractContext prev = ctx.prev;
        AbstractContext next = ctx.next;
        prev.next = next;
        next.prev = prev;
    }


    public ChannelPipeLine addLast(Handler handler) {

        DefaultContext newCtx = null;
        if (handler instanceof OutHandler) {

            newCtx = new DefaultContext("OutHandler#" + inCounter.getAndAdd(1), this, handler);

        } else if (handler instanceof InHandler) {

            newCtx = new DefaultContext("InHandler#" + outCounter.getAndAdd(1), this, handler);

        } else {
            throw new IllegalArgumentException("handler must be InHandler or OutHandler");
        }
        addLast0(newCtx);
        return this;
    }

    private void addLast0(AbstractContext newCtx) {
        AbstractContext prev = tail.prev;
        newCtx.prev = prev;
        newCtx.next = tail;
        prev.next = newCtx;
        tail.prev = newCtx;
    }


    public void request() {
        tail.request();
    }

    public void response() {
        head.response();
    }


    public ChannelPipeLine register() {
        head.register();
        return this;
    }


}

