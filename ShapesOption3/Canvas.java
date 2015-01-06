package ShapesOption3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private ArrayList mShapes = new ArrayList();

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < mShapes.size(); i++) {
            Shape o = (Shape) mShapes.get(i);
            o.draw(g);
        }

    }

    public void addShape(Shape s) {
        mShapes.add(s);
    }


}
