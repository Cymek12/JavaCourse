package zadModelowanieDanychPolimorfizm;

import java.util.Optional;

public class Appliance extends Product{
    private String energyClass;

    public Appliance(String name, String category, double price, double rating, boolean inStock, Optional<String> manufacturer) {
        super(name, category, price, rating, inStock, manufacturer);
    }

    @Override
    public String getSpecificDetails() {
        return "";
    }
}
