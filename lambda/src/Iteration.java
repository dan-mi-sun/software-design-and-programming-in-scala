import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iteration {
    public static void main(String[] args) {

        final List<String> people =
                Arrays.asList("Fred", "Brian", "John");

//        for (int i=0; i < people.size(); i++)
//            System.out.println(people.get(i));

//        for (String name : people)              // Iterator()
//            System.out.println(name);

//        people.forEach(new Consumer<String>() {
//            public void accept(String name) {
//                System.out.println(name);
//            }
//        });

//        people.forEach((String name) ->          // function -> lambda
//                System.out.println(name));
//

//          people.forEach(System.out::println);

        final List<String> upperCaseNames = new ArrayList<>();
        people.forEach(name -> upperCaseNames.add(name.toUpperCase()));
        System.out.println(upperCaseNames);

        people
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
