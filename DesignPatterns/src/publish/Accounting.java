package publish;

import java.util.Observable;
import java.util.Observer;

public class Accounting implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Employee) {
            // verify that monthly expenses are in line with the forecast
        }
    }
}