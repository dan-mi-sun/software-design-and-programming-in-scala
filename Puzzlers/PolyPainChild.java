package Puzzlers;

public class PolyPainChild extends PolyPain {
    public String name = "Child";

    public void Print() {
        System.out.println("Child");
    }

    public static void Print2() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        PolyPainChild c = new PolyPainChild();
        PolyPain p = (PolyPain) c;
        p.Print();
        p.Print2();
        System.out.println(p.name);
    }
}
