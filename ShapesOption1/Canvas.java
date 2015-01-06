package ShapesOption1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private ArrayList mCircles = new ArrayList();
    private ArrayList mSquares = new ArrayList();
    private ArrayList mRectangles = new ArrayList();

    public void paint(Graphics g) {
        for (int i = 0; i < mCircles.size(); i++) {
            Circle c = (Circle) mCircles.get(i);
            c.draw(g);
        }
        for (int i = 0; i < mSquares.size(); i++) {
            Square s = (Square) mSquares.get(i);
            s.draw(g);
        }
        for (int i = 0; i < mRectangles.size(); i++) {
            Rectangle s = (Rectangle) mRectangles.get(i);
            s.draw(g);
        }
    }

    public void addCircle(Circle c) {
        mCircles.add(c);
    }

    public void addSquare(Square s) {
        mSquares.add(s);
    }

    public void addRectangle(Rectangle s) {
        mRectangles.add(s);
    }


}
