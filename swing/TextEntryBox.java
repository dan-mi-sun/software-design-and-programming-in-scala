////////////////////////////////////////////////////////////////////////
/////	CS242	Advanced Programming Concepts in Java
/////
/////	file:	TextEntryBox.java
/////   from "Learning Java" by Niemeyer & Knudsen, O'Reilly, 2000.
////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEntryBox extends JFrame {

  public TextEntryBox(  ) {
    super("TextEntryBox v1.0");
    setSize(200, 300);
    setLocation(200, 200);

    final JTextArea area = new JTextArea(  );
    area.setFont(new Font("Serif", Font.BOLD, 18));
    area.setText("Howdy!\n");
    final JTextField field = new JTextField(  );

    Container content = getContentPane(  );
    content.add(new JScrollPane(area), BorderLayout.CENTER);
    content.add(field, BorderLayout.SOUTH);
    setVisible(true);
    field.requestFocus(  );

    field.addActionListener(new ActionListener(  ) {
      public void actionPerformed(ActionEvent ae) {
        area.append(field.getText(  ) + '\n');
        field.setText("");
      }
    });
  }

  public static void main(String[] args) {
    JFrame f = new TextEntryBox(  );
    f.addWindowListener(new WindowAdapter(  ) {
      public void windowClosing(WindowEvent we) { System.exit(0); }
    });
    f.setVisible(true);
  }
}
