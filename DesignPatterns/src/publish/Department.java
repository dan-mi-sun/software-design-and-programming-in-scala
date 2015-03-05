package publish;

import java.util.Observable;
import java.util.Observer;

public class Department implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Employee) {
            // deduct employees salary from department budget
        }
    }
}
