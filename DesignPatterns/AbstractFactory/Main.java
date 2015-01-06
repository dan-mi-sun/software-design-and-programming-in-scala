package DesignPatterns.AbstractFactory;

public class Main {

    public static void main(String args[]) {
        Car fordcar = new Car(new FordFactory());

        Car bmwcar = new Car(new BMWFactory());
    }
}
