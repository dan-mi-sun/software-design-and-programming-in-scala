package coreservlets.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtils {
  /** Returns first entry from list that passes the match function. This is
   *  a generalized version of EmployeeUtils.firstMatchingEmployee. 
   */
  public static <T> T firstMatch(List<T> candidates, Predicate<T> matchFunction) {
    for(T possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        return(possibleMatch);
      }
    }
    return(null); 
  }


  
  public static void printResult(Object param, Object match) {
    System.out.printf("  First match for %s: %s%n", param, match);
  }
  
  /** Returns a List of all entries from input list that pass the match function. 
   *  The result could be an empty List, but not null. This is very similar
   *  to the builtin "filter" method of Stream.
   */
  public static <T> List<T> allMatches(List<T> candidates, Predicate<T> matchFunction) {
    List<T> matches = new ArrayList<>();
    for(T possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        matches.add(possibleMatch);
      }
    }
    return(matches); 
  }
  
  public static List<Employee> findRichEmployees(List<Employee> employees, 
                                                 double salaryLowerBound) {
    return(allMatches(employees, e -> e.getSalary() >= salaryLowerBound));
  }
  
  public static <T,R> List<R> transform(List<T> origValues, 
                                        Function<T,R> transformer) {
    List<R> transformedValues = new ArrayList<>();
    for(T value: origValues) {
      transformedValues.add(transformer.apply(value));
    }
    return(transformedValues);
  }
  
  /** Returns a List with the given functions applied. The functions
   *  must all map their argument to an output of the SAME type (i.e., Function<T,T>).
   */
  public static <T> List<T> transform2(List<T> origValues, 
                                       Function<T,T> ... transformers) {
    Function<T,T> composedFunction = composeAll(transformers);
    return(transform(origValues, composedFunction));
  } 
  
  /** Returns composition of given functions. Given 0 or more functions,
   *  returns a new function that is a composition of them, in order. The functions
   *  must all map their argument to an output of the SAME type (i.e., Function<T,T>).
   */
  public static <T> Function<T,T> composeAll(Function<T,T> ... functions) {
    Function<T,T> result = Function.identity();
    for(Function<T,T> f: functions) {
      result = result.compose(f);
    }
    return(result);
  }
  
 
  public static int sum(List<Integer> nums) {  // See later version called sum2 that does the same thing via "collect"
    int sum = 0;
    for(int num: nums) {
      sum += num;
    }
    return(sum);
  }
  
  public static <T1,T2> void doTest(List<T1> entries, T2 arg, 
                                    BiFunction<List<T1>, T2, T1> operation, 
                                    String message) {
    T1 result = operation.apply(entries, arg);
    System.out.printf(message, arg, result);
  }
  
  public static <T1, T2, T3> void doTests(List<T1> values, 
                                          T2[] args, 
                                          BiFunction<List<T1>, T2, T1> operation, 
                                          String message) {
    for(T2 val: args) {
      doTest(values, val, operation, message);
    }
  }
  
  public static <T> void processEntries(List<T> entries,
                                        Consumer<T> operation) {
    for(T e: entries) {
      operation.accept(e);
    }
  }

  public static <T> T collect(List<T> entries, BinaryOperator<T> operation, T starter) {
    for(T entry: entries) {
      starter = operation.apply(starter, entry);
    }
    return(starter);
  }
  
  public static int sum2(List<Integer> nums) {
    return(collect(nums, Integer::sum, 0));
  }
  
  /** A generic and more flexible variation of EmployeeUtils.salarySum. */
  
  public static <T> int mapSum(List<T> entries, Function<T, Integer> mapper) {
    int sum = 0;
    for(T entry: entries) {
      sum += mapper.apply(entry);
    }
    return(sum);
  }
  
  public static int mapSum(List<Integer> entries) {
    return(mapSum(entries, Function.identity()));
  }
  
  public FunctionUtils() {} // Uninstantiatable class; static methods only
}
