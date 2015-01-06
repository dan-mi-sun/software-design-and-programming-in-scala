package fpij.collections;


import java.util.Arrays;
import java.util.List;

public class Iteration {
    public static void main(String[] args) {

        final List<String> people =
                Arrays.asList("Fred", "Brian", "John");

        for (int i=0; i < people.size(); i++)
            System.out.println(people.get(i));
    }
}
