package Vector;

public class Vector2D {

    private final double mX;
    private final double mY;

    public Vector2D(double x, double y) {
        mX = x;
        mY = y;
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    public Vector2D add(Vector2D w) {
        Vector2D result = new Vector2D(mX + w.mX, mY + w.mY);
        return result;
    }

}
