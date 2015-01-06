package ShapesOption1;

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

        c.addCircle(new Circle(100, 100));
        c.addSquare(new Square(350, 100));
        c.addRectangle(new Rectangle(350, 100));
    }


}
