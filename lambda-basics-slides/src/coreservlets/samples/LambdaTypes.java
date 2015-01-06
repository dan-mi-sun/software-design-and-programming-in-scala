package coreservlets.samples;

import java.io.Flushable;

public class LambdaTypes {
    public static void main(String[] args) {
        Runnable race1 = new Runnable() {
            public void run() {
                doSomething();
            }
        };
        printInfo("Anonymous inner class", race1);
        Runnable race2 = () -> doSomething();
        printInfo("Lambda assigned to Runnable", race2);
        Flushable toilet = () -> doSomething();
        printInfo("Lambda assigned to Flushable", toilet);
    }

    private static void doSomething() {
    }

    private static void printInfo(String label, Object o) {
        System.out.println(label);
        System.out.println("  Is this a Runnable? -- " + (o instanceof Runnable));
        System.out.println("  Type of this object -- " + (o.getClass().getName()));
    }
}
