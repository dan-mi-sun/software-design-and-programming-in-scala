package example04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickFirst {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Betty", "Bob", "Barnaby",
                "Frank", "Liam", "Fiona");


//        String foundName = null;
//        for (String name : friends)
//            if (name.startsWith("F")) {
//                foundName = name;
//                break;
//            }
//
//        if (foundName != null)
//            System.out.println("I found name: " + foundName);
//        else
//            System.out.println("No name");

        Optional<String> foundName =
                friends.stream()
                .filter(name -> name.startsWith("G"))
                .findFirst();

        System.out.println("A name starting with 'G' " + foundName.orElse("was not found"));
    }
}
