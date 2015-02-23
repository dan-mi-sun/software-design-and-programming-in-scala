package example04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PickNames {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Betty", "Bob", "Barnaby");

        Predicate<String> startsWithB =
                name -> name.startsWith("B");

        friends.stream()
//                .filter(name -> name.startsWith("B"))
                .filter(startsWithB)
                .forEach(System.out::println);

        friends.stream()
                .mapToInt(name -> name.length())
                .sum();

        String s =
                friends
                        .stream()
                        .reduce("Fred",
                                (name1, name2) ->
                                        name1.length() >= name2.length() ? name1 : name2);
        System.out.println(s);

    }
}
