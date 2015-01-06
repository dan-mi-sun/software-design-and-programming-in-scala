package Algorithms.GUI;


public class MemoryMonitor extends Thread {

    private long mMax = 0;

    synchronized public long GetMax() {
        return mMax;
    }

    synchronized public void ResetMax() {
        mMax = 0;
        System.gc();
    }

    public void run() {
        while (true) {
            long m = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            if (m > mMax) mMax = m;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

}
