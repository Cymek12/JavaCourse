package christmasHomework.zadAbstractProduct.utils;

import christmasHomework.zadAbstractProduct.model.Appliance;
import christmasHomework.zadAbstractProduct.model.Book;
import christmasHomework.zadAbstractProduct.model.Electronics;
import christmasHomework.zadAbstractProduct.model.*;


import java.util.List;
import java.util.Optional;

import static java.util.Arrays.*;

public class ProductData {


    public static List<Product> getProducts() {
        return asList(
                // Elektronika
                new Electronics("Laptop Lenovo", "Elektronika", 3000.00, 4.5, true, Optional.of("Lenovo"), 24),
                new Electronics("Smartphone Samsung", "Elektronika", 1500.00, 4.2, true, Optional.of("Samsung"), 12),
                new Electronics("Smartphone Xiaomi","Elektronika", 999.99, 4.0, false, Optional.empty(), 12),
                new Electronics("Telewizor Sony","Elektronika", 4000.00, 4.7, true, Optional.of("Sony"), 36),
                new Electronics("Laptop Dell","Elektronika", 2800.00, 4.4, true, Optional.of("Dell"), 24),

                // AGD
                new Appliance("Suszarka do włosów Philips", "Urządzenia", 200.00, 4.1, true, Optional.of("Philips"), "A++"),
                new Appliance("Mikser Bosch","Urządzenia", 250.00, 4.3, true, Optional.of("Bosch"), "A+"),
                new Appliance("Odkurzacz Dyson", "Urządzenia",1200.00, 4.6, false, Optional.of("Dyson"), "A++"),

                // Książki
                new Book("Książka Java 11", "Ksiązka",89.99, 4.8, true, Optional.empty(), "John Doe"),
                new Book("Książka Algorytmy","Ksiązka", 120.00, 4.5, false, Optional.empty(), "Jane Smith")
        );
    }
}