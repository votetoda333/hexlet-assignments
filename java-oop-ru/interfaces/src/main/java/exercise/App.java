package exercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class App {
    private static Arrays homes;

    public static List<String> buildApartmentsList(List<Home> apartments, int n){
        List<Home> sortedHomes = apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n)
                .collect(Collectors.toList());

        return sortedHomes.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

}
