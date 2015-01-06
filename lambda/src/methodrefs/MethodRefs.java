package methodrefs;


import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

public class MethodRefs {
    private final static int SIZE = 10;
    public static void main(String[] args) {
        Person[] people = new Person[SIZE];
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Arrays.sort(people, byName);
    }
}

@Data
class Person {
    private final String name;
    private final int age;
}