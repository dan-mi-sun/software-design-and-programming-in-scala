package coreservlets.streams;

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class FibStream {
  
  /** Makes an "infinite" (unbounded) stream of Fibonacci numbers
   *  (1, 1, 2, 3, 5, 8, 13, 21, 34, and so forth).
   *  This method is for when you want to control the size-limiting steps later.
   *  The more common usage is the next method, where you limit the
   *  size in the call to the original method.
   */
  public static Stream<Long> makeFibStream() {
    return(Stream.generate(new FibonacciMaker()));
  }
  
  /** Makes a Stream of the specified number of Fibonacci numbers. */
  
  public static Stream<Long> makeFibStream(int numFibs) {
    return(makeFibStream().limit(numFibs));
  }
  
  /** Makes a List of the specified number of Fibonacci numbers. */
  
  public static List<Long> makeFibList(int numFibs) {
    return(makeFibStream(numFibs).collect(toList()));
  }
  
  /** Makes an array of the specified number of consecutive n-digit primes */
  // toArray returns Object[], not T[], so the typecast is needed
  
  public static Long[] makeFibArray(int numFibs) {
    return((Long[])makeFibStream(numFibs).toArray());
  } 
  
  private FibStream() {} // Uninstantiatable class
}
