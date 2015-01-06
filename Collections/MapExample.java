package Collections;

import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        TreeMap tm = new TreeMap();

        tm.put(new Integer(5), "I love ");
        tm.put(new Integer(7), "Java");

        System.out.println(tm.get(new Integer(5)));
        System.out.println(tm.get(new Integer(7)));


    }

}
