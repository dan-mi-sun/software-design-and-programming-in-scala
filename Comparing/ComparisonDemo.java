package Comparing;

import java.util.ArrayList;
import java.util.Collections;

public class ComparisonDemo {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Al", "Koholic", 55));
        people.add(new Person("Ivana", "Tinkle", 20));
        people.add(new Person("Jacques", "Strap", 60));
        people.add(new Person("Amanda", "Hugginkiss", 20));

        for (Person p : people) {
            p.print();
        }
        System.out.println("");

        Collections.sort(people);
        for (Person p : people) p.print();

        System.out.println("");
        Collections.sort(people, new ForenameComparator());
        for (Person p : people) p.print();

        System.out.println("");
        Collections.sort(people, new AgeComparator());
        for (Person p : people) p.print();
        System.out.println("");
    }
}
