package Algorithms.GUI;

import Algorithms.Sorting.BubbleSort;
import Algorithms.Sorting.HeapSort;
import Algorithms.Sorting.InsertionSort;
import Algorithms.Sorting.JavaSort;
import Algorithms.Sorting.MergeSort;
import Algorithms.Sorting.QuickSortFirst;
import Algorithms.Sorting.QuickSortLast;
import Algorithms.Sorting.QuickSortRandom;
import Algorithms.Sorting.SelectionSort;
import Algorithms.Sorting.SortFailure;
import Algorithms.Sorting.SortTester;

import java.util.Vector;

public class SortingThread extends Thread {

    private SeriesStore mSeriesStore;
    private MemoryMonitor mMonitor;

    public SortingThread(SeriesStore ss) {
        mSeriesStore = ss;
    }

    public void run() {
        // Set up something to do the sorting
        SortTester insertion = new SortTester(new InsertionSort());
        SortTester selection = new SortTester(new SelectionSort());
        SortTester bubble = new SortTester(new BubbleSort());
        SortTester merge = new SortTester(new MergeSort());
        SortTester quick1 = new SortTester(new QuickSortFirst());
        SortTester quick2 = new SortTester(new QuickSortLast());
        SortTester quick3 = new SortTester(new QuickSortRandom());
        SortTester java = new SortTester(new JavaSort());
        SortTester heap = new SortTester(new HeapSort());

        Vector<SortTester> algorithms = new Vector<SortTester>();
        algorithms.add(insertion);
        algorithms.add(selection);
        algorithms.add(bubble);
        algorithms.add(merge);
        algorithms.add(quick1);
        //algorithms.add(quick2);
        //algorithms.add(quick3);
        algorithms.add(java);
        algorithms.add(heap);

        for (SortTester st : algorithms) {
            mSeriesStore.AddSeries(st.GetID());
            mSeriesStore.GetSeries(st.GetID()).Add(0, 0, st.GetID());
        }


        for (int n = 500; n < 1000000; n += 500) {

            // Load in some data
            int[] testdata = SortTester.LoadArray("/home/robert/Teaching/AlgorithmsI/random.txt", n);


            for (SortTester s : algorithms) {

                // 	Sort the data twice and take the quickest result (a poor attempt to
                // minimise the effects of system processes interfering with the timing)
                try {
                    long time = Long.MAX_VALUE;
                    for (int i = 0; i < 2; i++) {
                        int[] data = testdata.clone();
                        long t = s.SortArray(data);
                        if (t < time) time = t;
                    }
                    mSeriesStore.GetSeries(s.GetID()).Add(n, time, s.GetID());
                } catch (SortFailure sf) {
                    System.err.println("Whoops: sorting algorithm failed!");
                }

            }

        }

        System.out.println("Finished");
    }

}
