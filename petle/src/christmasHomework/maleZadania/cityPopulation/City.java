package christmasHomework.maleZadania.cityPopulation;

public class City {
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{name='" + name + "', population=" + population + '}';
    }
}