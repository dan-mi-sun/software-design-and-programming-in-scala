package Comparing;

import java.util.Comparator;

public class ForenameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return (p1.getForename().compareTo(p2.getForename()));
    }
}
