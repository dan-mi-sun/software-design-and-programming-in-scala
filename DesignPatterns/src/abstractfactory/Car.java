package abstractfactory;

public class Car {

    private CarWindow mWindow;
    private CarEngine mEngine;
    private CarFactoryInterface mFactory;

    public Car(CarFactoryInterface factory) {
        // Use the factory to fill in the parts
        mWindow = factory.getWindow();
        mEngine = factory.getEngine();
        mFactory = factory;
    }

}
