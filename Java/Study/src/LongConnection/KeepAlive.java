package LongConnection;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 维持连接的消息对象
 * Created by joshua on 16/8/20.
 *
 * @author fanteathy
 */
public class KeepAlive implements Serializable {

    private static final long serialVersionUID = -2813120366138988480L;

    public String toString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t维持连接包";
    }
}
