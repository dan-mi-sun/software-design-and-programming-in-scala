/*
 * ButtonGUI.java is a simple example
 * (depends on java 1.4 and up)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonGUI  implements ActionListener {
	private static String labelPrefix = "Number of button clicks: ";
	private int numClicks = 0;
	final JLabel label = new JLabel(labelPrefix + "0    ");

	public Component createComponents() {
		JButton button = new JButton("Click Me!");
		button.setMnemonic(KeyEvent.VK_I);
		button.addActionListener(this);
		label.setLabelFor(button);

		/*
		 * An easy way to put space between a top-level container and its
		 * contents is to put the contents in a JPanel that has an "empty"
		 * border.
		 */
		JPanel pane = new JPanel(new GridLayout(0, 1));
		pane.add(button);
		pane.add(label);
		pane.setBorder(BorderFactory.createEmptyBorder(30, // top
				30, // left
				10, // bottom
				30) // right
		);

		return pane;
	}

	public void actionPerformed(ActionEvent e) {
		numClicks++;
		label.setText(labelPrefix + numClicks);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("Button Clicks");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGUI mywindow = new ButtonGUI();
		Component contents = mywindow.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
