package BouncingBall;

import java.util.Random;

/**
 * This class sets up the 'experiment' in simulation
 * and executes it
 *
 * @author rkh23
 */
public class Simulation2 {

    /**
     * Time increment on each loop
     */
    public static final double sDeltaTime = 0.005;

    /**
     * The floor height
     */
    private final double mFloorHeight = 1.0;

    /**
     * The balls we are simulating
     */
    private final int mNumBalls = 500;
    private Ball mBalls[] = new Ball[mNumBalls];

    /**
     * A visualisation component (not important to understand in depth)
     */
    private final Visualisation mVisualisation = new Visualisation(mFloorHeight, 0.0, 5.0, mBalls);

    /**
     * The simulation entry point.  This enters a loop which continually
     * increments the simulated 'time', updates the state of the ball, and
     * produces some result.
     */
    public void run() {
        Random random = new Random();
        for (int i = 0; i < mBalls.length; i++) {
            double k = random.nextDouble() / 2 + 0.5;
            double y = (random.nextDouble() * 3) + 2.0;
            double vx = (random.nextDouble()) * 4.0;
            double vy = (random.nextDouble() * 2) + 1.0;
            mBalls[i] = new Ball(k, -4.5, y, vx, vy, 0.0, -9.81);
        }

        while (true) {

            for (int i = 0; i < mBalls.length; i++) {
                Ball b = mBalls[i];
                b.updateState(sDeltaTime, this.mFloorHeight);
            }
            mVisualisation.repaint();
            // Make the simulation wait after each iteration otherwise
            // the simulated time runs so fast that we don't see anything
            // in the visualisation!!!
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }


    /**
     * The program entry point.  Not very exciting!
     *
     * @param args Arguments passed to the program
     */
    public static void main(String[] args) {

        Simulation2 sim = new Simulation2();
        sim.run();
    }


}
