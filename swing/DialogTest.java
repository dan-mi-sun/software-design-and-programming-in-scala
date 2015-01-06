////////////////////////////////////////////////////////////////////////
/////	CS242	Advanced Programming Concepts in Java
/////
/////	file:	DialogTest.java
/////   from Core Java I by Cay Horstmann
////////////////////////////////////////////////////////////////////////

import javax.swing.*;

/**
   @version 1.00 2000-01-07
   @author Cay Horstmann
*/
public class DialogTest
{
   public static void main(String[] args)
   {
      // get first input
      String name = JOptionPane.showInputDialog
         ("What is your name?");

      // get second input
      String input = JOptionPane.showInputDialog
         ("How old are you?");

      try {
      // convert string to integer value
      int age = Integer.parseInt(input);

      // display output on console
      System.out.println("Hello, " + name +
         ". Next year, you'll be " + (age + 1));

      } catch(NumberFormatException exc) {
         System.out.println(input + " isn't a valid number");
      }

      System.exit(0);
   }
}
