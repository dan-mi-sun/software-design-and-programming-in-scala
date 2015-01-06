
import javax.swing.JOptionPane;

/*
 * Example of a simple dialog and exception handling
 */

public class DialogTest3 {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog
         ("What is your name?");

        boolean invalidAge = true;

        while (invalidAge) {
           String input = JOptionPane.showInputDialog
              ("How old are you?");
           try {
               int age = Integer.parseInt(input);
               invalidAge = false;
               System.out.println("Hello, " + name +
                  ". Next year, you'll be " + (age + 1));
	      } catch(NumberFormatException exc) {

			  System.out.println("Try again, but this time "
			     + "input a valid integer for your age.");
	      }
      }
   }
}
