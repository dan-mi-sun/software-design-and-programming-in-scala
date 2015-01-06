package coreservlets.samples;

import java.util.function.DoubleUnaryOperator;

public class LambdaScoping {
    private double value1 = 1.2;
    private double x = 5.0;

    private double value2() {
        return (3.4);
    }

    public void doSomethingWith(double num) {
        // blah
    }

    private void someMethod(DoubleUnaryOperator funct) {
        // Ignore it
    }

    private void illegal1() {
        double x = 1.2;
        // Next line is illegal: variable x is already defined
        // someMethod(x -> doSomethingWith(x));
    }

    private void illegal2() {
        double x = 1.2;
        // Next line is illegal: variable x is already defined (as above)
        // someMethod(y -> { double x = 5.6; return(x); });
    }

    private void illegal3() {
        double x = 1.2;
        // Next line is illegal: local variables used must be final or effectively final, and thus cannot be modified
        //someMethod(y -> x = 3.4);
    }

    public void useLambdas() {
        double value3 = 5.6;
        DoubleUnaryOperator lambda1 = x -> x + value1;
        DoubleUnaryOperator lambda2 = x -> x + value2();
        DoubleUnaryOperator lambda3 = x -> x + value3;
        DoubleUnaryOperator lambda4 = x -> {
            this.x = this.x * 2;
            return (x + this.x);
        };
        double x = 7.8;
        System.out.printf("For x=7.8, lambda1=%.2f, lambda2=%.2f, lambda3=%.2f, lambda4=%.2f, lambda4=%.2f%n",
                lambda1.applyAsDouble(x), lambda2.applyAsDouble(x),
                lambda3.applyAsDouble(x), lambda4.applyAsDouble(x), lambda4.applyAsDouble(x));
    }

    public static void main(String[] args) {
        LambdaScoping test = new LambdaScoping();
        test.useLambdas();
    }

}
