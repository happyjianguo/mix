package test.ringbuffer;

import com.lmax.disruptor.EventFactory;

/**
 * Created by joshua on 16/11/24.
 */
public class LongEventFactory implements EventFactory {
    public Object newInstance() {
        return new LongEvent();
    }
}
