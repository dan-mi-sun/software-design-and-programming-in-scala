
//////////////////////////////////////////////////////////////////////////
///// file: TestCloseableFrame.java
///// 
///// This programs makes use of an anonymous inner class to terminate
///// the main program when the window is closed.
//////////////////////////////////////////////////////////////////////////

import java.awt.event.*;
import javax.swing.*;

class CloseableFrame extends JFrame
{
   public CloseableFrame()
   {
      setTitle("Closeable Frame");
      setSize(300, 200);
      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
               {
                  System.exit(0);
               }
         } );
   }
}

public class TestCloseableFrame
{
   public static void main(String[] args)
   {
      JFrame frame = new CloseableFrame();
      frame.setVisible(true);
   }
}

