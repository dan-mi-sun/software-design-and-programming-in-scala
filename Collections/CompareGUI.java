package Collections;

import Algorithms.GUI.SeriesStore;
import Algorithms.GUI.XYSeriesPlotter;

import javax.swing.JFrame;

public class CompareGUI extends JFrame implements Runnable {
    private SeriesStore mSeriesStore = null;
    private XYSeriesPlotter mPlot = null;

    @SuppressWarnings("deprecation")
    public CompareGUI(SeriesStore s) {
        this.setSize(1000, 700);
        mSeriesStore = s;
        mPlot = new XYSeriesPlotter(mSeriesStore);
        this.add(mPlot);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.show(true);
        Thread t = new Thread(this);
        t.start();
    }


    public static void main(String args[]) {
        SeriesStore ss = new SeriesStore();
        //CompareThread ct = new CompareThread(ss);
        IteratorCompare ct = new IteratorCompare(ss);
        ct.start();
        CompareGUI gui = new CompareGUI(ss);

    }

    public void run() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception o) {
            }
        }
    }

}

