package zadModelowanieDanychPolimorfizm;

import java.util.Optional;

public abstract class Product {
    private String name;
    private String category;
    private double price;
    private double rating;
    private boolean inStock;
    private Optional<String> manufacturer;

    public Product(String name, String category, double price, double rating, boolean inStock, Optional<String> manufacturer) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.inStock = inStock;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Optional<String> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Optional<String> manufacturer) {
        this.manufacturer = manufacturer;
    }

    public abstract String getSpecificDetails();



}
