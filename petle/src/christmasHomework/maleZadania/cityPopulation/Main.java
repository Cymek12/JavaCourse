package christmasHomework.maleZadania.cityPopulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Warszawa", 1800000));
        cities.add(new City("Krakow", 780000));
        cities.add(new City("Gdansk", 470000));
        cities.add(new City("Wroclaw", 640000));
        cities.add(new City("Poznan", 530000));
        cities.add(new City("Lodz", 690000));
        cities.add(new City("Berlin", 3700000));
        cities.add(new City("Praga", 1300000));
        cities.add(new City("Wieden", 1900000));
        cities.add(new City("Monachium", 1500000));


        Map<String, Integer> collect = cities.stream()
                .filter(s -> s.getPopulation() > 1000000)
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getPopulation()));

    }
}


