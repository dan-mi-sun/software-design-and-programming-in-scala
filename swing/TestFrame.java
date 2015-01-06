//////////////////////////////////////////////////////////////////////////
///// file: TestFrame.java
///// This program creates a simple window and makes it appear.
///// One problem is that the main program does not terminate when
///// the window is closed.  You must hit <Ctrl>c to terminate the program
//////////////////////////////////////////////////////////////////////////

import javax.swing.*;

class SimpleFrame extends JFrame
{
   public SimpleFrame()
   {
      setTitle("Simple Frame");
      setSize(300, 200);  // in pixels (defaults to 0,0)
   }
}

public class TestFrame
{
   public static void main(String[] args)
   {
      JFrame frame = new SimpleFrame();
      // The above creates the window, but it doesn't show up yet

      frame.setVisible(true);  // now the window appears
   }
}
