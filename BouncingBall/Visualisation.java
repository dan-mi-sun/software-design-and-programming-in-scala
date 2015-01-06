package BouncingBall;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class is a quick and dirty implementation of some graphics
 * so we can visualise the bouncing ball in the lecture.
 * <p/>
 * You should NOT worry about anything you see in this
 * file.  You can completely ignore it if you like!
 *
 * @author rkh23
 */
public final class Visualisation extends JFrame {

    /**
     * This is an inner class of Visualisation and represents
     * the on-screen component that draws the ball and the simulation 'world'
     *
     * @author Robert
     */
    private class BallPanel extends JPanel {
        private double mFloor;
        private double mMax;
        private double mMin;
        private final int mBorder = 20;
        private Ball mBalls[] = null;

        public BallPanel(double floor, double min, double max, Ball balls[]) {
            mFloor = floor;
            mMax = max;
            mMin = min;
            mBalls = balls;

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            int w = this.getWidth() / 2;
            int h = this.getHeight();
            g2.setColor(Color.white);
            g2.fillRect(0, 0, w * 2, h);
            double scale = (this.getHeight() - mBorder * 2) / (mMax - mMin);
            // Draw the floor
            g2.setColor(Color.blue);
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(0, h - ((int) (mFloor * scale) + mBorder), getWidth(), h - ((int) (mFloor * scale) + mBorder));
            for (int i = 0; i < mBalls.length; i++) {
                Ball b = mBalls[i];
                g2.setColor(Color.magenta);
                int x = (int) (b.getPosition().getX() * scale);
                int y = (int) (b.getPosition().getY() * scale);
                g2.fillOval(w + x - 7, h - y - mBorder - 12, 15, 15);
            }
        }


        public void setFloorHeight(double y) {
            mFloor = y;
        }

    }

    /**
     * An instance of our inner BallPanel class
     */
    private BallPanel mBallPanel = null;


    /**
     * The constructor
     *
     * @param floorheight Height to draw the floor at
     * @param minheight   Smallest height drawn on screen
     * @param maxheight   Greatest height drawn on screen
     */
    public Visualisation(double floorheight, double minheight, double maxheight, Ball balls[]) {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        mBallPanel = new BallPanel(floorheight, minheight, maxheight, balls);
        this.setSize(1024, 700);
        this.getContentPane().add(mBallPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }


    /**
     * Standard mutator
     *
     * @param y
     */
    public void setFloorHeight(double y) {
        mBallPanel.setFloorHeight(y);
    }


}
