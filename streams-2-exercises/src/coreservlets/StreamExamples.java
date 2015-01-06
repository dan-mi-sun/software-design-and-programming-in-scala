package coreservlets;

import java.util.*;

public class StreamExamples {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
    System.out.printf("Original words: %s.%n", words);
    String upperCaseWords = words.stream().reduce("", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
    System.out.printf("Single uppercase String: %s.%n", upperCaseWords);
    String upperCaseWords2 = words.stream().map(String::toUpperCase).reduce("", String::concat);
    System.out.printf("Single uppercase String: %s.%n", upperCaseWords2);
    String wordsWithCommas = words.stream().reduce((s1, s2) -> s1 + "," + s2).orElse("need at least two strings");
    System.out.printf("Comma-separated String: %s.%n", wordsWithCommas);
    System.out.printf("3 random nums: %s.%n", StreamUtils.randomNumberList(3));
    System.out.printf("10 numbers starting at 50, by 5's: %s.%n", StreamUtils.orderedNumberList(50, 5, 10));
    List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
    int sum1 = nums1.stream().reduce(0, Integer::sum);
    System.out.printf("Serial sum of %s is %s.%n", nums1, sum1);
    int sum2 = nums1.stream().parallel().reduce(0, Integer::sum);
    System.out.printf("Parallel sum of %s is %s.%n", nums1, sum2);
    System.out.println(Double.MIN_VALUE);
    List<Double> nums2 = Arrays.asList(0.000000000001, 200000000000.0, 0.000000000003, 400000000000.0);
    double product1 = nums2.stream().reduce(1.0, (n1, n2) -> n1 * n2);
    System.out.printf("Serial product of %s is %s.%n", nums2, product1);
    double product2 = nums2.stream().parallel().reduce(1.0, (n1, n2) -> n1 * n2);
    System.out.printf("Parallel product of %s is %s.%n", nums2, product2);
  }
}
