package ShapesOption2;

import java.awt.Graphics;

public class Circle extends Shape {
    private int mX;
    private int mY;

    public Circle(int x, int y) {
        mX = x;
        mY = y;
    }

    public void draw(Graphics g) {
        g.drawOval(mX, mY, 300, 300);
    }
}
