package zadAbstractProduct;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductService {

    static public List<Product> filterProducts(List<Product> products, Predicate<Product> predicate){
        return products.stream()
                .filter(predicate)
                .toList();
    }

    static public <R> List<R> mapProducts(List<Product> products, Function<Product, R> mapper){
        return products.stream()
                .map(mapper)
                .toList();
    }

    static public <R> void forEachProduct(List<R> data, Consumer<R> consumer){
        data.stream().forEach(consumer);
    }

    static public Optional<Product> findBestRatedProduct(List<Product> products, String category){
        return products.stream()
                .filter(s -> s.getCategory().equals(category))
                .sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return -Double.compare(o1.getRating(), o2.getRating());
                    }
                })
                .findFirst();
    }

    static public OptionalDouble calculateAveragePrice(List<Product> products, String category){
        return products.stream()
                .filter(s -> s.getCategory().equals(category))
                .mapToDouble(s -> s.getPrice())
                .average();
    }

    static public Map<String, List<Product>> groupProductsByCategory(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.getCategory()));
    }

    static public Map<String, Long> countProductsWithAndWithoutManufacturer(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(s -> {
                    if(s.getManufacturer().isPresent()){
                        return "Jest Producent";
                    }
                    else {
                        return "Brak Producenta";
                    }
                }
                , Collectors.counting()));
    }


}
