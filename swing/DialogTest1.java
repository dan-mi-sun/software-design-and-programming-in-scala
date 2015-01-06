import javax.swing.JOptionPane;

/*
 * Example of a simple dialog and exception handling
 */

/**
 * Shows the need for exception handling
 */
public class DialogTest1 {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog
         ("What is your name?");

        String input = JOptionPane.showInputDialog
              ("How old are you?");

        int age = Integer.parseInt(input);

        System.out.println("Hello, " + name +
            ". Next year, you'll be " + (age + 1));

      }
}
