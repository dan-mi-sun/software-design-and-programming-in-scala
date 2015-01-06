package coreservlets;

import java.util.*;
import java.util.function.*;
import static java.util.stream.Collectors.*;

public class StreamExamples {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
    System.out.println("Words (with spaces):");
    words.stream().forEach(s -> System.out.println("  " + s));
    System.out.println("Words (no spaces):");
    words.stream().forEach(System.out::println);
    List<String> excitingWords = words.stream()
                                      .map(s -> s + "!")
                                      .collect(toList());
    System.out.printf("Exciting words: %s.%n", excitingWords);
    List<String> eyeWords = words.stream()
                                 .map(s -> s.replace("i", "eye"))
                                 .collect(toList());
    System.out.printf("Eye words: %s.%n", eyeWords);
    List<String> upperCaseWords = words.stream()
                                       .map(String::toUpperCase)
                                       .collect(toList());
    System.out.printf("Uppercase words: %s.%n", upperCaseWords);
    List<String> shortWords = words.stream()
                                   .filter(s -> s.length() < 4)
                                   .collect(toList());
    System.out.printf("Short words: %s.%n", shortWords);
    List<String> wordsWithB = words.stream()
                                   .filter(s -> s.contains("b"))
                                   .collect(toList());
    System.out.printf("B words: %s.%n", wordsWithB);
    List<String> evenLengthWords = words.stream()
                                        .filter(s -> (s.length() % 2) == 0)
                                        .collect(toList());
    System.out.printf("Even-length words: %s.%n", evenLengthWords);
    String result1 = firstFunnyString(words, "E");
    System.out.println("Uppercase short word with 'E': " + result1);
    String result2 = firstFunnyString(words, "Q");
    System.out.println("Uppercase short word with 'Q': " + result2);
    Function<String,String> toUpper = s -> { System.out.println("Uppercasing " + s);
                                             return(s.toUpperCase());
                                            };
    String result3 = words.stream()
                          .map(toUpper)
                          .filter(s -> s.length() < 4)
                          .filter(s -> s.contains("E"))
                          .findFirst().orElse("No match");
    System.out.println("Uppercase short word with 'E': " + result3);
    String[] excitingWords2 = words.stream()
                                   .map(s -> s + "!")
                                   .toArray(String[]::new);
    System.out.printf("Exciting words as array: %s.%n", Arrays.asList(excitingWords2));
  }
  
  public static String firstFunnyString(List<String> words, String containedTest) {
    String result =
      words.stream()
           .map(String::toUpperCase)
           .filter(s -> s.length() < 4)
           .filter(s -> s.contains(containedTest))
           .findFirst().orElse("No match");
    return(result);
  }
}
