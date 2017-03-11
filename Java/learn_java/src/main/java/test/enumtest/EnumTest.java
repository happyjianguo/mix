package test.enumtest;

/**
 * Created by joshua on 17/3/11.
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.FRIDAY));
        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we);
        }

        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we.toString());
        }
    }
}
