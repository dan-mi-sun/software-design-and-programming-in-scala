import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonPanelv3 extends JPanel
{

   private JButton button1;
   private JButton button2;

   public ButtonPanelv3() {

      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

      button1 = new JButton("red");

      button2 = new JButton("blue");

      // add the buttons to the panel
      add(Box.createHorizontalGlue());
      add(button1);
      add(Box.createHorizontalStrut(15));
      add(button2);
      add(Box.createHorizontalGlue());

      // registers the buttons & action listeners
      button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	  setBackground(Color.red);
	  repaint();
        }
      });

      button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setBackground(Color.blue);
	  repaint();
        }
      });
   }

     /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorSelector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0,1));

        ButtonPanelv2 toolBar = new ButtonPanelv2();
        frame.getContentPane().add(toolBar);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
