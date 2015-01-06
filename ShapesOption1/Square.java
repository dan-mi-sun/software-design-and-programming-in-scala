package ShapesOption1;

import java.awt.Graphics;

public class Square {
    private int mX;
    private int mY;

    public Square(int x, int y) {
        mX = x;
        mY = y;
    }

    public void draw(Graphics g) {
        g.drawRect(mX, mY, 200, 200);
    }
}