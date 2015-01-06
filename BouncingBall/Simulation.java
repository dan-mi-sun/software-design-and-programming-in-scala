package BouncingBall;

/**
 * This class sets up the 'experiment' in simulation
 * and executes it
 *
 * @author rkh23
 */
public class Simulation {

    /**
     * Time increment on each loop
     */
    public static final double sDeltaTime = 0.005;

    /**
     * The floor height
     */
    private final double mFloorHeight = 1.0;

    /**
     * The ball we are simulating
     */
    private final Ball mBall = new Ball(0.8,
            -4.5, 2.0,
            2.0, 3.0,
            0.0, -9.81);

    private Ball mBalls[] = new Ball[]{mBall};

    /**
     * A visualisation component (not important to understand in depth)
     */
    private final Visualisation mVisualisation =
            new Visualisation(mFloorHeight, 0.0, 5.0, mBalls);

    /**
     * The simulation entry point.  This enters a loop which continually
     * increments the simulated 'time', updates the state of the ball, and
     * produces some result.
     */
    public void run() {

        while (true) {

            // Update the ball
            mBall.updateState(sDeltaTime, this.mFloorHeight);
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

        Simulation sim = new Simulation();
        sim.run();
    }


}
