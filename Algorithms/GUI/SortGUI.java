package Algorithms.GUI;

import javax.swing.JFrame;

public class SortGUI extends JFrame implements Runnable {
    private SeriesStore mSeriesStore = null;
    private XYSeriesPlotter mPlot = null;

    @SuppressWarnings("deprecation")
    public SortGUI(SeriesStore s) {
        this.setSize(1000, 650);
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
        SortingThread st = new SortingThread(ss);
        st.start();
        SortGUI gui = new SortGUI(ss);
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
