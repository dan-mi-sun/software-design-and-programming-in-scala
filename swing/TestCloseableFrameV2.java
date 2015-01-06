
//////////////////////////////////////////////////////////////////////////
///// file: TestCloseableFrameV2.java
///// 
///// This version of a closeable frame uses the static constant
///// EXIT_ON_CLOSE to terminate the main program when the window is
///// closed.  It will only work on Java versions 1.3 and above.
//////////////////////////////////////////////////////////////////////////

import java.awt.event.*;
import javax.swing.*;

class CloseableFrameV2 extends JFrame
{
   public CloseableFrameV2()
   {
      setTitle("Closeable Frame");
      setSize(300, 200);
      // note: the following only works in Java 1.3 and higher
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

public class TestCloseableFrameV2
{
   public static void main(String[] args)
   {
      JFrame frame = new CloseableFrameV2();
      frame.setVisible(true);
   }
}

