package example01;

import java.util.Arrays;
import java.util.List;

public class Discount {
    public static void main(String[] args) {
        final List<Integer> prices = Arrays.asList(10,15,20,25);

        System.out.println("Total of discounted prices " +
            discountImperative(prices));
        System.out.println("Total of discounted prices " +
                discountFunctional(prices));
    }

    static Double discountImperative(List<Integer> lint){
        double totalOfDiscountedPrices = 0.0;

        for (Integer item: lint)
            totalOfDiscountedPrices += item * 0.9;
        return totalOfDiscountedPrices;
    }

    static Double discountFunctional(List<Integer> lint){
        return lint.stream().parallel()
                .mapToDouble( price -> price * 0.9).sum();
    }
}
