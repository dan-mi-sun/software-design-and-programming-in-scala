package Algorithms.Sorting;

import java.util.Random;

public class QuickSortRandom extends QuickSort {
    private Random mRandom = new Random();

    @Override
    public String GetID() {
        return "Quick-Random";
    }

    /**
     * Select a random pivot
     */
    @Override
    protected int SelectPivot(int[] array, int first, int last) {
        int numElements = last - first + 1;
        return first + mRandom.nextInt(numElements);
    }

}
