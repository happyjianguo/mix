package test.testguava;

import com.google.common.base.Joiner;

import java.util.Arrays;

public class JoinerTest {

    public static void main(String[] args) {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
