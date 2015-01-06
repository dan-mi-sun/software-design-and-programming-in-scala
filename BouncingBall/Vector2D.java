package BouncingBall;

/**
 * A class that represents a simple two dimensional
 * vector. The class is immutable because there are no set methods
 *
 * @author rkh23
 */
public class Vector2D {
    /**
     * The x component
     */
    private final double mX;

    /**
     * The y component
     */
    private final double mY;

    /**
     * Constructor
     *
     * @param x x value
     * @param y y value
     */
    public Vector2D(double x, double y) {
        mX = x;
        mY = y;
    }

    /**
     * Get the x component of the vector
     *
     * @return
     */
    public double getX() {
        return mX;
    }

    /**
     * Get the y component of the vector
     *
     * @return
     */
    public double getY() {
        return mY;
    }


    /**
     * Scalar multiplication of a 2D vector
     * Returns a new Vector2D object with the result
     *
     * @param m The factor to scale by
     * @return A new Vector2D containing the scaled result
     */
    public Vector2D scale(double m) {
        return new Vector2D(m * mX, m * mY);
    }

    /**
     * Addition of two vectors v1+v2
     * Returns a new Vector2D object with the result
     *
     * @param v Vector to add
     * @return A new Vector2D containing the  result
     */
    public Vector2D add(Vector2D v) {
        return new Vector2D(mX + v.mX, mY + v.mY);
    }

    /**
     * Subtraction of two vectors v1-v2
     * returns a new Vector2D object with the result
     *
     * @param v Vector to subtract
     * @return A new Vector2D containing the  result
     */
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(mX - v.mX, mY - v.mY);
    }

}
