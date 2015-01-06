package Algorithms.Sorting;

public class QuickSortLast extends QuickSort {

    @Override
    public String GetID() {
        return "Quick-Last";
    }

    @Override
    protected int SelectPivot(int[] array, int first, int last) {
        return last;
    }

}
