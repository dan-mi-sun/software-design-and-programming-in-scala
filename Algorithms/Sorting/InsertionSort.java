package Algorithms.Sorting;

public class InsertionSort implements Sorter {


    @Override
    public void Sort(int[] array) {

        for (int k = 0; k < array.length - 1; k++) {
            int j = k + 1;
            while (j > 0 && array[j - 1] > array[j]) {
                int tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
                j--;
            }
        }

    }


    public String GetID() {
        return "Insert";
    }
}
