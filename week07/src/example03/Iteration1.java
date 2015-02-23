package example03;

import java.util.Arrays;
import java.util.List;

public class Iteration1 {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Betty", "Bob", "James");

//        for(int i=0; i < friends.size(); i++)
//            System.out.println(friends.get(i));
//
//        for(String name: friends)     // Iterators
//            System.out.println(name);

//        friends.forEach(new MyConsumer<>());
//        friends.forEach(new Consumer<String>(){
//            public void accept(String t){
//                System.out.println(t);
//            }
//        });
//        friends.forEach((String name) -> System.out.println(name));
//        friends.forEach(name -> System.out.println(name));
//        friends.forEach(System.out::println);

        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);

        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.println(count));

    }

}

//class MyConsumer<T> implements Consumer<T> {
//    public void accept(T t){
//        System.out.println(t);
//    }
//}
