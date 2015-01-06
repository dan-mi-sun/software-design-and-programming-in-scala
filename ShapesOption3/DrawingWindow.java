package ShapesOption3;

import javax.swing.JFrame;

public class DrawingWindow extends JFrame {

    public DrawingWindow(Canvas c) {
        this.setSize(1000, 600);
        this.getContentPane().add(c);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        Canvas c = new Canvas();
        DrawingWindow dw = new DrawingWindow(c);

        c.addShape(new Circle(100, 100));
        c.addShape(new Square(350, 100));
        c.addShape(new Rectangle(400, 200));

    }


}
