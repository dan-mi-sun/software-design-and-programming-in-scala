package Comparing;

public class Equals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "Hello";
        String s2 = new String("Hello");

        if (s == s2) System.out.println("Same");
        else System.out.println("Different");

        if (s.equals(s2)) System.out.println("Same");
        else System.out.println("Different");


        Person p = new Person("a", "b", 12);
        Person p2 = new Person("c", "d", 13);
        Person p3 = new Person("a", "b", 12);

        System.out.println(p == p2);
        System.out.println(p == p3);
        System.out.println(p.equals(p2));
        System.out.println(p.equals(p3));

    }

}
