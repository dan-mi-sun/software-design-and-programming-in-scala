package Generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GenericsDemo {


    public static void main(String[] args) {
        List<String> l = new LinkedList<>();

        Map<Integer, Double> tm = new TreeMap<>();
        tm.put(new Integer(3), new Double(8.0));
        l.add(new String("a"));
        l.add(new String("b"));

        for (String s : l) {
            System.out.println(s);
        }

    }
}
