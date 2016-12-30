package test.common;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by joshua on 16/12/30.
 */
public class CommonTime {

    public static void main(String[] args) {
        Date now = new Date();
        String nowDay = DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss");
        System.out.println(nowDay);

        Date tenDaysAfter = DateUtils.addDays(now, 10);
        System.out.println(DateFormatUtils.format(tenDaysAfter, "yyyy/MM/dd HH:mm:ss"));

        Timestamp timestamp = new Timestamp(now.getTime());
        System.out.println(timestamp);
    }
}
