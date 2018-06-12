package test.testguava;

import com.google.common.base.Preconditions;

public class PreconditionTest {

    public static void main(String[] args) {

        PreconditionTest test = new PreconditionTest();
        System.out.println(test.sqrt(-3.0));

    }

    public double sqrt(double input) {
        Preconditions.checkArgument(input > 0.0, "Illegal Argument");
        return Math.sqrt(input);
    }
}
