package coreservlets.integratable;

public class IntegrationTest2 {
    public static void main(String[] args) {
        MathUtils.printExpectedAnswer(10, 100, "x^2", "100^3/3 - 10^3/3",
                (Math.pow(100, 3) / 3.0 - Math.pow(10, 3) / 3.0));
        MathUtils.integrationTest(x -> x * x, 10, 100);
        MathUtils.printExpectedAnswer(50, 500, "x^3", "500^4/4 - 50^4/4",
                (Math.pow(500, 4) / 4.0 - Math.pow(50, 4) / 4.0));
        MathUtils.integrationTest(x -> Math.pow(x, 3), 50, 500);
        MathUtils.printExpectedAnswer(0, Math.PI, "sin(x)", "-cos(pi) - -cos(0)",
                (-Math.cos(Math.PI) - -Math.cos(0)));
        MathUtils.integrationTest(x -> Math.sin(x), 0, Math.PI);
        System.out.println("Alternative representation");
        MathUtils.integrationTest(Math::sin, 0, Math.PI);
        MathUtils.printExpectedAnswer(2, 20, "e^x", "e^20 - e^2",
                (Math.pow(Math.E, 20) - Math.pow(Math.E, 2)));
        MathUtils.integrationTest(x -> Math.exp(x), 2, 20);
        System.out.println("Alternative representation");
        MathUtils.integrationTest(Math::exp, 2, 20);
    }
}
