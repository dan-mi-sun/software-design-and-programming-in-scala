package coreservlets;

import java.util.*;
import java.util.function.*;

public class StringUtils {
  public static List<String> allMatches(List<String> candidates, 
                                        Predicate<String> matchFunction) {
    List<String> results = new ArrayList<>();
    for(String possibleMatch: candidates) {
      if(matchFunction.test(possibleMatch)) {
        results.add(possibleMatch);
      }
    }
    return(results); 
  }
  
  
  public static List<String> transformedList(List<String> originals, 
                                             Function<String, String> transformer) {
    List<String> results = new ArrayList<>();
    for(String original: originals) {
      results.add(transformer.apply(original));
    }
    return(results); 
  }
  
  private StringUtils() {} // Uninstantiatable class
}
