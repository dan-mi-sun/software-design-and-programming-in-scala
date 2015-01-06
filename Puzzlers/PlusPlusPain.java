package Puzzlers;


public class PlusPlusPain {

    public static void method1() {
        int j = 0;
        for (int i = 0; i < 100; i++) j = j++;
        System.out.println(j);
    }

    public static void method2() {
        int j = 0;
        int i = (j++) + (j++);
        System.out.println(i + " " + j);
    }

    public static void main(String[] args) {
        PlusPlusPain.method1();
        PlusPlusPain.method2();
    }

}
