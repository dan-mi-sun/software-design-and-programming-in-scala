package coreservlets;

import java.util.Arrays;

import static coreservlets.ArrayUtils.printArray;

// import static means that I can say printArray(...)
// instead of ArrayUtils.printArray(...).

public class SortingExamples {
    public static void main(String[] args) {
        String[] words = {"hi", "hello", "hola", "bye", "goodbye", "adios"};
        System.out.print("Original array: ");
        printArray(words);
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        System.out.print("Sorted by length ascending: ");
        printArray(words);
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        System.out.print("Sorted by length descending : ");
        printArray(words);
        Arrays.sort(words, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.print("Sorted by first letter : ");
        printArray(words);
        Arrays.sort(words, (s1, s2) ->
        {
            int compareFlag = 0;
            if (s1.contains("e") && !s2.contains("e")) {
                compareFlag = -1;
            } else if (s2.contains("e") && !s1.contains("e")) {
                compareFlag = 1;
            }
            return (compareFlag);
        });
        System.out.print("Sorted by whether it contains 'e' [v1] : ");
        printArray(words);
        Arrays.sort(words, StringUtils::eChecker);
        System.out.print("Sorted by whether it contains 'e' [v2] : ");
        printArray(words);
    }
}
