package coffee;

import dagger.ObjectGraph;

import javax.inject.Inject;

public class CoffeeApp implements Runnable {
    @Inject
    CoffeeMaker coffeeMaker;

    @Override
    public void run() {
        coffeeMaker.brew();
    }

    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(new DripCoffeeModule());
        CoffeeApp coffeeApp = objectGraph.get(CoffeeApp.class);
        coffeeApp.run();
    }
}
