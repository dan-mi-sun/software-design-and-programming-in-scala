package Algorithms.Sorting;

public class SelectionSort implements Sorter {

    @Override
    public void Sort(int[] array) {
        for (int k = 0; k < array.length; k++) {
            int imin = k;
            for (int j = imin + 1; j < array.length; j++) {
                if (array[j] < array[imin]) {
                    imin = j;
                }
            }
            int tmp = array[k];
            array[k] = array[imin];
            array[imin] = tmp;
        }

    }

    public String GetID() {
        return "Select";
    }

}
