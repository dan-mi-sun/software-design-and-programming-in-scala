package Collections;

import Algorithms.GUI.SeriesStore;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorCompare extends Thread {

    private SeriesStore mSeriesStore;

    public IteratorCompare(SeriesStore ss) {
        mSeriesStore = ss;
    }

    public void run() {
        //LinkedList l = new LinkedList();
        ArrayList l = new ArrayList();


        mSeriesStore.AddSeries("Iterator");
        mSeriesStore.AddSeries("For loop");
        mSeriesStore.AddSeries("For each loop");


        for (int i = 0; i < 1000; i++) l.add(1);

        for (int n = 1; n < 1000; n++) {
            for (int i = 0; i < 100; i++) l.add(1);

            // using a standard for loop
            long start = System.nanoTime();
            int length = l.size();
            for (int i = 0; i < length; i++) {
                l.get(i);
            }
            long t = System.nanoTime() - start;
            mSeriesStore.GetSeries("For loop").Add(n, t, "For loop");

            // Using Java's Iterator class
            start = System.nanoTime();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t = System.nanoTime() - start;
            mSeriesStore.GetSeries("Iterator").Add(n, t, "Iterator");

            // Using the new for each loop as per practicals
            start = System.nanoTime();
            for (Object o : l) {
            }
            t = System.nanoTime() - start;
            mSeriesStore.GetSeries("For each loop").Add(n, t, "For each loop");


        }

        System.out.println("Finished");
    }

}
