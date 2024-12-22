package zadAbstractProduct;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = ProductData.getProducts();

//        zad 1
//        Przefiltruj produkty dostępne i tańsze niż 1000 zł.
//        List<Product> filteredProducts = ProductService.filterProducts(products, s -> s.getPrice() < 1000.0);
//        filteredProducts.forEach(s -> System.out.println(s.getSpecificDetails()));

//        zad2
//        Wyszukiwanie Najlepszego Produktu w Kategorii "Elektronika"
//        Optional<Product> bestRatedProduct = ProductService.findBestRatedProduct(products, "Elektronika");
//        if(bestRatedProduct.isPresent()){
//            System.out.println(bestRatedProduct.get().getSpecificDetails());
//        }
//        else {
//            System.out.println("Nie znaleziono produktu");
//        }

//        zad3
//        Obliczanie Średniej Ceny w Kategorii "AGD"
//        OptionalDouble avgAGD = ProductService.calculateAveragePrice(products, "AGD");
//        if(avgAGD.isPresent()){
//            System.out.println(avgAGD.getAsDouble());
//        }
//        else {
//            System.out.println("Nie znaleziono produktu");
//        }


//        zad4
//        Grupowanie Produktów według Kategorii
//        Map<String, List<Product>> groupedProductsByCategory = ProductService.groupProductsByCategory(products);
//        groupedProductsByCategory.get("Elektronika").forEach(System.out::println);


//        zad5
//        Przefiltruj produkty dostępne, tańsze niż 1000 zł oraz z kategorii "Elektronika".
//        List<Product> filteredProducts =
//                ProductService.filterProducts(products, s -> s.getPrice() < 1000.0 && s.getCategory().equals("Elektronika"));
//        filteredProducts.forEach(System.out::println);


//        zad6
//        Spróbuj znaleźć najlepszego ocenianego produktu w kategorii "Komputery".
//        Optional<Product> bestRatedProduct = ProductService.findBestRatedProduct(products, "Komputery");
//        if(bestRatedProduct.isPresent()){
//            System.out.println(bestRatedProduct.get().getSpecificDetails());
//        }
//        else {
//            System.out.println("Nie znaleziono produktu");
//        }


//        zad7
//        Pobierz elektronikę z minimalnym okresem gwarancji i wypisz ich szczegóły.
//        List<Electronics> electronics = Electronics.getElectronicsWithWarranty(products, 20);
//        electronics.forEach(s -> System.out.println(s.getSpecificDetails()));


//        zad8
//        Pobierz książki danego autora i wypisz ich szczegóły.
//        List<Book> booksByAuthor = Book.getBooksByAuthor(products, "John Smith");
//        booksByAuthor.forEach(s -> System.out.println(s.getSpecificDetails()));


    }
}
