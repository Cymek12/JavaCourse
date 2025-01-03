package christmasHomework.zadAbstractProduct.utils;

import christmasHomework.zadAbstractProduct.model.*;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    Predicate<Product> isAvailableAndCheap = (s -> s.isInStock() && s.getPrice() < 1000.00);
    Predicate<Product> isElectronics = (s -> s.getCategory().equals("Elektronika"));
    Function<Product, String> productToString = (s ->
         "nazwa (cena: " + s.getPrice() + "zł, producent: " + s.getManufacturer() + ")"
    );
    Consumer<String> printString = System.out::println;

}
