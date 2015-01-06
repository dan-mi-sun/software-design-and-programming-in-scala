package ShapesOption2;

import java.awt.Graphics;

public class Rectangle extends Shape {
    private int mX;
    private int mY;

    public Rectangle(int x, int y) {
        mX = x;
        mY = y;
    }

    public void draw(Graphics g) {
        g.drawRect(mX, mY, 500, 200);
    }
}