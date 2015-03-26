Question
========

Complete the `partition` function which is defined as follows:

    def partition(list : Seq[Int], pivot: Int) : (Seq[Int], Seq[Int]) = ???
    
The result of the function is a pair containing two lists of `Int` values. 
The first `Seq` in the pair should contain all of the values in `Seq` less than `pivot`. 
The second sequence in the pair should contain all of the values greater than or equal to `pivot`.

When you run the program it creates a random list and calls the `partition` method, using the first 
element in the list as the pivot. An example run of the program is:

    Original list: List(542, 655, 284, 498, 779, 761, 592, 754, 301, 56)
    After partitioning on first element 542
    (List(56, 301, 498, 284),List(754, 592, 761, 779, 655, 542))
    
Note that the order of the elements in each of the result lists is not important.

Requirement: your implementation must be tail-recursive.


Now add the following code to the bottom of your program:

    val sorted = quickSort(list)
    println("Sorted list: " + sorted)
    
and define the `quickSort` function. 
The `quickSort` function should use the `partition` function to implement the quick sort algorithm. 
Quick sort works by partitioning an unsorted list, recursively sorting the resulting partitions, 
and combining the sorted partitions into a single list.