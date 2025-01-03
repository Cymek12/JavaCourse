package christmasHomework.zadAbstractProduct.model;

import java.util.Optional;

public class Appliance extends Product {
    private String energyClass;

    public Appliance(String name, String category, double price, double rating, boolean inStock, Optional<String> manufacturer, String energyClass) {
        super(name, category, price, rating, inStock, manufacturer);
        this.energyClass = energyClass;
    }

    public String getEnergyClass() {
        return energyClass;
    }

    public void setEnergyClass(String energyClass) {
        this.energyClass = energyClass;
    }

    @Override
    public String getSpecificDetails() {
        return super.toString() + " klasa energetyczna = " + energyClass ;
    }
}
