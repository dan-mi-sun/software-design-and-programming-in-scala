package Algorithms.Sorting;

import java.util.Arrays;

public class JavaSort implements Sorter {

    @Override
    public String GetID() {
        return "Java";
    }

    @Override
    public void Sort(int[] array) {
        Arrays.sort(array);
    }

}
