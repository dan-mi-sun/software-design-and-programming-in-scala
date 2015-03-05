package publish;

import java.util.Observable;
import java.util.Observer;

public class Manager extends Employee implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Employee) {
            // note employee's salary, vacation days, etc.
        }
    }
}