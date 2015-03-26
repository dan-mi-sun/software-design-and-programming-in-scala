Question
========

Write a Scala program that reads a double value `b` and an integer value `k` as input, and them computes the value `b` raised to the power `k` and prints it.
If the value of k is less than or equal to zero then that is considered an error.

Requirements:
* You must write a recursive function to compute the power
* Your solution must be tail-recursive

Example run:

    Enter b: 2.0 
    Enter k: 3 
    8.0
    
You can use the following code to get the user input:

    print("Enter b: ")
    val b = readLine().toDouble
    print("Enter k: ")
    val k = readLine().toInt

