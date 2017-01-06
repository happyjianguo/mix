package test.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by joshua on 16/11/24.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
