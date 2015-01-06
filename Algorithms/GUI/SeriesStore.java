package Algorithms.GUI;

import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class SeriesStore {

    public class Series {
        public Series(String nm) {
            name = nm;
        }

        public String GetName() {
            return name;
        }

        public long GetX(int i) {
            return ((Long) x.get(i)).longValue();
        }

        public long GetY(int i) {
            return ((Long) y.get(i)).longValue();
        }

        ;

        synchronized public void Add(long lx, long ly, String lname) {
            x.add(new Long(lx));
            y.add(new Long(ly));
            xLabels.add(lname);
            if (lx > mMaxX) mMaxX = lx;
            if (lx < mMinX) mMinX = lx;
            if (ly > mMaxY) mMaxY = ly;
            if (ly < mMinY) mMinY = ly;

        }

        public void Toggle() {
            if (mDraw) mDraw = false;
            else mDraw = true;
        }

        public boolean Draw() {
            return mDraw;
        }

        public String GetXLabel(int i) {
            return (String) xLabels.get(i);
        }

        public int GetSize() {
            return x.size();
        }

        private String name;
        private Vector x = new Vector();
        private Vector y = new Vector();
        private Vector xLabels = new Vector();
        private boolean mDraw = true;
    }

    ;

    private TreeMap mSeriesMap = new TreeMap();

    public int GetNumSeries() {
        return mSeriesMap.size();
    }

    public Set GetKeys() {
        return mSeriesMap.keySet();
    }

    public Series GetSeries(String key) {
        return (Series) mSeriesMap.get(key);
    }

    public void AddSeries(String key) {
        mSeriesMap.put(key, new Series(key));
    }

    synchronized public long GetMinX() {
        return mMinX;
    }

    ;

    synchronized public long GetMaxX() {
        return mMaxX;
    }

    ;

    synchronized public long GetMinY() {
        return mMinY;
    }

    ;

    synchronized public long GetMaxY() {
        return mMaxY;
    }

    ;

    public void Toggle(String s) {
        Series ss = GetSeries(s);
        ss.Toggle();
    }

    private long mMinX = 1000, mMaxX = 0, mMinY = 1000, mMaxY = 0;

}
