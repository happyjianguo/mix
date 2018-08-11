package test.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TestLambda {

    public static void main(String[] args) {
        new TestLambda().testMath();
    }

    public void testThread() {
        new Thread(() -> System.out.println("hello")).start();
    }

    public void testList() {
        List features = Arrays.asList("Monday", "Tuesday", "Wednesday");
        features.stream().forEach(entity -> System.out.println(entity));
    }

    public void testMap() {
        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> (int) cost + 1)
                .forEach(System.out::println);
    }

    public void testFilter() {
        List<String> strList = Arrays.asList("abc", "bcd", "fanteathy");
        List<String> filter = strList.stream().filter(x -> x.length() > 3)
                .collect(Collectors.toList());
        System.out.println(filter);
    }

    public void testFunc() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println(G7Countries);
    }

    public void testMath() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List: " + stats.getMax());
    }

}
