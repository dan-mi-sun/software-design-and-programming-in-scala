package Algorithms.Sorting;

public class QuickSortFirst extends QuickSort {

    @Override
    public String GetID() {
        return "Quick-First";
    }

    @Override
    protected int SelectPivot(int[] array, int first, int last) {
        return first;
    }

}
