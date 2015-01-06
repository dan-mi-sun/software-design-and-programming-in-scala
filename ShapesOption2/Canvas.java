package ShapesOption2;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;


public class Canvas extends JPanel {

    private ArrayList mShapes = new ArrayList();

    public void paint(Graphics g) {
        for (int i = 0; i < mShapes.size(); i++) {
            Shape o = (Shape) mShapes.get(i);

            if (o instanceof Circle) {
                Circle c = (Circle) o;
                c.draw(g);
            } else if (o instanceof Square) {
                Square sq = (Square) o;
                sq.draw(g);
            } else if (o instanceof Rectangle) {
                Rectangle sq = (Rectangle) o;
                sq.draw(g);
            }

        }

    }

    public void addShape(Shape s) {
        mShapes.add(s);
    }


}
