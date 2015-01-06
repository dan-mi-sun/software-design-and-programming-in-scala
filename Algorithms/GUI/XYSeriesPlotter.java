package Algorithms.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Iterator;
import java.util.Set;


public class XYSeriesPlotter extends Component {

    private SeriesStore mStore;

    private long mMinX;
    private long mMaxX;
    private long mMinY;
    private long mMaxY;

    private double mScaleFactorX;
    private double mScaleFactorY;
    private long mBorder = 70;

    private Color mColours[] = {Color.red,
            Color.blue,
            Color.green,
            Color.black,
            Color.gray,
            Color.magenta,
            Color.orange,
            Color.pink,
            Color.yellow};
    private int mColourIndex = 0;

    public XYSeriesPlotter(SeriesStore s) {
        mStore = s;

        mMinX = s.GetMinX();
        mMaxX = s.GetMaxX();
        mMinY = s.GetMinY();
        mMaxY = s.GetMaxY();

        this.setSize(100, 100);

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        mColourIndex = 0;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fill(new Rectangle(0, 0, getSize().width, getSize().height));


        mMinX = mStore.GetMinX();
        mMaxX = mStore.GetMaxX();
        mMinY = mStore.GetMinY();
        ;
        mMaxY = mStore.GetMaxY();

        mMaxY = (mMaxY / 10000 + 1) * 10000;

        Dimension d = getSize();
        mScaleFactorX = (double) (d.width - 2 * mBorder) / (mMaxX - mMinX);
        mScaleFactorY = (double) (d.height - 2 * mBorder) / (mMaxY - mMinY);

        // Draw axes through (0,0)
        g2.setColor(Color.black);
        Line2D xaxis = new Line2D.Double(0.0 + mBorder,
                d.height - mBorder,
                d.width - mBorder,
                d.height - mBorder);
        g2.draw(xaxis);
        Line2D yaxis = new Line2D.Double(0.0 + mBorder,
                d.height - mBorder,
                0.0 + mBorder,
                mBorder);
        g2.draw(yaxis);


        for (int i = 0; i <= 10; i++) {
            long v = ((mMaxY - mMinY) / 10 * i);
            float xx = (float) (0.0 + mBorder - 60);
            float stagger = (float) ((d.height - 2 * mBorder) / 10.0);
            float yy = (float) (d.height - mBorder - stagger * i);
            g2.drawString("" + v,
                    xx,
                    yy);
        }

        for (int i = 0; i <= 5; i++) {
            long v = ((mMaxX - mMinX) / 5 * i);
            float stagger = (float) ((d.width - 2 * mBorder) / 5.0);
            float xx = (float) (mBorder + stagger * i - 10);
            float yy = (float) (d.height - mBorder + 20);
            g2.drawString("" + v,
                    xx,
                    yy);
        }

        Set nodes = mStore.GetKeys();
        Iterator it = nodes.iterator();
        boolean first = true;
        int k = 0;
        while (it.hasNext()) {
            k++;
            String node = (String) it.next();
            SeriesStore.Series s = mStore.GetSeries(node);
            g2.setColor(mColours[mColourIndex]);
            if (first) {
                g2.drawString(s.GetName(),
                        mBorder + 20,
                        mBorder + 15 * k);
            }
            if (s.Draw()) DrawSeries(g2, s);
            mColourIndex = (mColourIndex + 1) % mColours.length;
        }
    }

    private void DrawSeries(Graphics2D g2, SeriesStore.Series s) {
        long x0 = s.GetX(0);
        long y0 = s.GetY(0);
        for (int i = 1; i < s.GetSize(); i++) {

            long x1 = s.GetX(i);
            long y1 = s.GetY(i);
            Dimension d = getSize();

            double rad = 3;
            Ellipse2D e = new Ellipse2D.Double(mBorder + (x1 - mMinX) * mScaleFactorX - rad, d.height - mBorder - (y1 - mMinY) * mScaleFactorY - rad, 2 * rad, 2 * rad);
            //g2.fill(e);

            Line2D segment = new Line2D.Double(mBorder + (x0 - mMinX) * mScaleFactorX,
                    d.height - mBorder - (y0 - mMinY) * mScaleFactorY,
                    mBorder + (x1 - mMinX) * mScaleFactorX,
                    d.height - mBorder - (y1 - mMinY) * mScaleFactorY);
            g2.draw(segment);

            x0 = x1;
            y0 = y1;
        }
    }


}


