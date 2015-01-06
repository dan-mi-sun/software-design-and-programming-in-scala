
////////////////////////////////////////////////////////////////////////
/////	CS242	Advanced Programming Concepts in Java
/////   file:	TestButtons.java
/////	
////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestButtons
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Buttons");
        frame.getContentPane().add(new ButtonPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200); // 200 x 200 pixels  
        frame.setVisible(true);
    }
}

class ButtonPanel 
    extends JPanel 
    implements ActionListener
{
    private JButton button1;
    private JButton button2;
    private Color currentColor = Color.red;

    public ButtonPanel()
    {
        button1 = new JButton("red");
        button2 = new JButton("blue");

        setBackground(currentColor);

        // adds the buttons to the JPanel
        add(button1);
        add(button2);

        // registers the buttons & action listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
     }

     public void actionPerformed(ActionEvent evt)
     {
         Object source = evt.getSource();
         if (source == button1)
             currentColor = Color.red;
         else if (source == button2)
             currentColor = Color.blue;
         setBackground(currentColor);
         repaint();
     }
}
