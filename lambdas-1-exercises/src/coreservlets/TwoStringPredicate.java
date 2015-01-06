package coreservlets;

/**
 * An interface for which lambdas can be used. See StringUtils for
 * examples of USING this interface in code, which are more or less the same
 * as in Java 7. But, see IsBetterExamples for examples of PASSING IN
 * instances of this interface, where now in Java 8 you can use lambdas.
 * Also see TwoElementPredicate for a genericized version of this interface.
 */
@FunctionalInterface
public interface TwoStringPredicate {
    /**
     * Returns true if the first String is "better" than the second one,
     * returns false otherwise. Concrete classes (or lambdas) that implement
     * this interface give meaning to their definition of "better".
     */
    public boolean isBetter(String s1, String s2);
}
