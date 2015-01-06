package coreservlets.function;

import java.util.Random;

public class RandomUtils {
    private static Random r = new Random();

    /**
     * Return a random int from 0 to range-1. So, randomInt(4)
     * returns any of 0, 1, 2, or 3.
     */

    public static int randomInt(int range) {
        return (r.nextInt(range));
    }

    /**
     * Return a random index of an array.
     */

    public static int randomIndex(Object[] array) {
        return (randomInt(array.length));
    }

    /**
     * Return a random element from an array.
     * Uses generics, so no typecast is required
     * for the return value.
     */

    public static <T> T randomElement(T[] array) {
        return (array[randomIndex(array)]);
    }
}
