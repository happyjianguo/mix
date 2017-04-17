package test.mixtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joshua on 17/4/17.
 */
public class RegDemo {

    public static void main(String[] args) {

        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }
}
