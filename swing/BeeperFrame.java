import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeeperFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton button;

	public BeeperFrame() {
		// create a button and add it to the content pane
		button = new JButton("Ding!");
		getContentPane().add(button, BorderLayout.CENTER);

		// register this frame as an action listener for the button
		button.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// make frame large enough for the components contained in it
		pack();

	}

	public void actionPerformed(ActionEvent e) {
		// the frame will ring the bell when the button is clicked
		Toolkit.getDefaultToolkit().beep();
	}

	/* main program launches the GUI (not thread-safe) */
	public static void main(String[] args) {
		BeeperFrame frame = new BeeperFrame();
		frame.setVisible(true);
	}
}
