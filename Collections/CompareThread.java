package Collections;

import Algorithms.GUI.SeriesStore;

import java.util.ArrayList;
import java.util.LinkedList;

public class CompareThread extends Thread {

    private SeriesStore mSeriesStore;

    public CompareThread(SeriesStore ss) {
        mSeriesStore = ss;
    }

    public void run() {
        LinkedList l = new LinkedList();
        ArrayList v = new ArrayList();
        mSeriesStore.AddSeries("LinkedList");
        mSeriesStore.AddSeries("ArrayList");

        for (int n = 1; n < 1000; n++) {
            for (int i = 0; i < 1000; i++) l.add(1);
            long start = System.nanoTime();
            l.get(n * 1000 / 2);
            long t = System.nanoTime() - start;
            mSeriesStore.GetSeries("LinkedList").Add(n, t, "LinkedList");

            for (int i = 0; i < 1000; i++) v.add(1);
            start = System.nanoTime();
            v.get(n * 1000 / 2);
            long t2 = System.nanoTime() - start;

            mSeriesStore.GetSeries("ArrayList").Add(n, t2, "ArrayList");
        }

        System.out.println("Finished");
    }

}
