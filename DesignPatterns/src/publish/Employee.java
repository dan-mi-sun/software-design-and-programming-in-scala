package publish;

import java.util.Observable;

public class Employee extends Observable {
    private double salary;

    public void setSalary(double amount) {
        this.salary = amount;
        super.setChanged();
        super.notifyObservers();
    }
}