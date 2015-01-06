import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonPanelv1 extends JPanel
   implements ActionListener
   {

   private JButton button1;
   private JButton button2;

   public ButtonPanelv1() {

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
      button1.addActionListener(this);
      button2.addActionListener(this);
      }

   public void actionPerformed(ActionEvent evt)
   {
      Object source = evt.getSource();
      Color color = getBackground();

      if (source == button1)
         color = Color.red;
      else if (source == button2)
         color = Color.blue;

      setBackground(color);
      repaint();
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

        ButtonPanelv1 toolBar = new ButtonPanelv1();
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