package BouncingBall;

/**
 * Represents the state and properties of a ball
 *
 * @author rkh23
 */
public class Ball {

    private double mK = 0.0;
    private Vector2D mPosition = null;
    private Vector2D mVelocity = null;
    private Vector2D mAcceleration = null;


    /**
     * Constructor initialises a ball
     *
     * @param k  Coefficient of restitution
     * @param x  Starting position in x
     * @param y  Starting position in y
     * @param vx Starting speed in x
     * @param vy Starting speed in y
     * @param ax Starting acceleration in x
     * @param ay Starting acceleration in y
     */
    public Ball(double k,
                double x, double y,
                double vx, double vy,
                double ax, double ay) {
        mK = k;
        mPosition = new Vector2D(x, y);
        mVelocity = new Vector2D(vx, vy);
        mAcceleration = new Vector2D(ax, ay);
    }

    public Vector2D getPosition() {
        return mPosition;
    }

    public void setPosition(Vector2D p) {
        mPosition = p;
    }

    public void setVelocity(Vector2D v) {
        mVelocity = v;
    }

    public void setAcceleration(Vector2D a) {
        mAcceleration = a;
    }

    /**
     * Use the equations of motion to update the ball's state
     * assuming delta seconds have elapsed since the last update
     *
     * @param delta_t Time delta since last update
     */
    public void updateState(double delta_t, double floorheight) {
        // Update the position on the assumption that the
        // velocity was constant over the update period
        // (this is justifiable for small delta t)
        // s = ut + 1/2 at^2
        Vector2D ut = mVelocity.scale(delta_t);
        Vector2D att = mAcceleration.scale(delta_t * delta_t * 0.5);
        Vector2D pos = ut.add(att).add(mPosition);

        if (mPosition.getY() < floorheight) {
            handleCollision(floorheight);
        } else {
            // Set the position
            mPosition = pos;
            // Update the velocity
            // v = u+at
            mVelocity = mAcceleration.scale(delta_t).add(mVelocity);
        }
        // Capture when it stops
        if (mPosition.getY() != mPosition.getY()) {
            mPosition = new Vector2D(mPosition.getX(), floorheight);
            mVelocity = new Vector2D(0.0, 0.0);
            mAcceleration = new Vector2D(0.0, 0.0);
        }
    }

    private void handleCollision(double floorheight) {
        // First figure out when it struck the floor
        // We solve s=ut+1/2at^2  for t
        double s = mPosition.getY() - floorheight;
        double t = (-mVelocity.getY() + Math.sqrt(mVelocity.getY() * mVelocity.getY() - 2.0 * mAcceleration.getY() * s)) / mAcceleration.getY();
        if (t < 0.0)
            t = (-mVelocity.getY() - Math.sqrt(mVelocity.getY() * mVelocity.getY() - 2.0 * mAcceleration.getY() * s)) / mAcceleration.getY();

        // How fast was it going when it hit?
        double vy = mVelocity.getY() + mAcceleration.getY() * t;

        // What *speed* will it rebound at?
        double vr = Math.abs(mK * vy);

        // Where will it have gotten to in the remainder of the time step?
        // s = ut + 1/2 at^2
        double t2 = Simulation.sDeltaTime - t;
        double py = vr * t2 + mAcceleration.getY() * t2 * t2 + floorheight;

        // How fast will it be moving?
        vy = vr + mAcceleration.getY() * t2;

        // Update the Ball
        setPosition(new Vector2D(mPosition.getX(), py));
        setVelocity(new Vector2D(mVelocity.getX() / 1.2, vy));
    }


}
