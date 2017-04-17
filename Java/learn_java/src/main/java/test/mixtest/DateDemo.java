package test.mixtest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joshua on 17/4/17.
 */
public class DateDemo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
//        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("Current Date: " + ft.format(date));
    }
}
