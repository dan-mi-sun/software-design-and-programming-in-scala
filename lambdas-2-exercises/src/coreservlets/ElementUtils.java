package coreservlets;

import java.util.*;
import java.util.function.*;

public class ElementUtils {
  public static <T> List<T> allMatches(List<T> candidates, 
                                       Predicate<T> matchFunction) {
    List<T> results = new ArrayList<>();
    for(T possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        results.add(possibleMatch);
      }
    }
    return(results); 
  }

  public static <T, R> List<R> transformedList(List<T> originals, 
                                               Function<T, R> transformer) {
    List<R> results = new ArrayList<>();
    for(T original: originals) {
      results.add(transformer.apply(original));
    }
    return(results); 
  }
  
  private ElementUtils() {} // Uninstantiatable class
}
