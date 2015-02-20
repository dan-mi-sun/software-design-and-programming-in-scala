package example01;

import java.util.Arrays;
import java.util.List;

public class Cities {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("NYC","Chicago","Frankfurt");

        findCityImperative(cities, "Chiago");
        findCityFunctional(cities,"Chicago");
    }

    public static void findCityImperative(final List<String> cities, String name){
        boolean found = false;
        for(String city: cities)
            if(city.equals(name)){
                found = true;
                break;
            }
        System.out.println("Found " + name + " ?: " + found);
    }

    public static void findCityFunctional(final List<String> cities, String name){
        System.out.println("Found " + name + " ?: " + cities.contains(name));
    }
}
