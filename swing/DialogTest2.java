
import javax.swing.JOptionPane;

/*
 * Example of a simple dialog and exception handling
 */

public class DialogTest2 {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog
           ("What is your name?");

        String inputAge = JOptionPane.showInputDialog
           ("How old are you?");

        try {
           int age = Integer.parseInt(inputAge);

            System.out.println("Hello, " + name +
                  ". Next year, you'll be " + (age + 1));
	    } catch(NumberFormatException exc) {
			System.err.println("Input a valid integer for your age.");
	    }
      }

}
