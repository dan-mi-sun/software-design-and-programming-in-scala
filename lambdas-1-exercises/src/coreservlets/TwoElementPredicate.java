package coreservlets;

/**
 * An interface for which lambdas can be used. See StringUtils for
 * examples of USING this interface in code, which are more or less the same
 * as in Java 7. But, see IsBetterExamples for examples of PASSING IN
 * instances of this interface, where now in Java 8 you can use lambdas.
 * Also see TwoStringPredicate for a weaker version of this interface
 * that works only for Strings.
 */
@FunctionalInterface
public interface TwoElementPredicate<T> {
    /**
     * Returns true if the first entry is "better" than the second one,
     * returns false otherwise. Concrete classes (or lambdas) that implement
     * this interface give meaning to their definition of "better".
     */
    public boolean isBetter(T element1, T element2);
}
