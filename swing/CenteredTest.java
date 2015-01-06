import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CenteredFrame extends JFrame {
	public CenteredFrame() {
		// add a title
		setTitle("CenteredFrame");

		// when this window is closed, abort the main program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// use the toolkit to get the current screensize
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;

		// make this window 1/4th the area of the screen
		setSize(screenWidth / 2, screenHeight / 2);

		// center the window on the screen
		setLocation(screenWidth / 4, screenHeight / 4);

		// add an icon to the window title bar
		Image img = tk.getImage("icon.gif");
		setIconImage(img);
	}
}

public class CenteredTest {
	public static void main(String[] args) {
		JFrame frame = new CenteredFrame();
		frame.setVisible(true);
	}
}
