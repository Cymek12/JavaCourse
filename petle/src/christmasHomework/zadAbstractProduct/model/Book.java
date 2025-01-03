package christmasHomework.zadAbstractProduct.model;

import java.util.List;
import java.util.Optional;

public class Book extends Product {
    private String author;

    public Book(String name, String category, double price, double rating, boolean inStock, Optional<String> manufacturer, String author) {
        super(name, category, price, rating, inStock, manufacturer);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String getSpecificDetails() {
        return super.toString() + " autor = " + author ;
    }

    static List<Book> getBooksByAuthor(List<Product> products, String author){
        return products.stream()
                .filter(s -> s instanceof Book)
                .filter(s -> ((Book) s).getAuthor().equals(author))
                .map(s -> (Book) s)
                .toList();
    }
}
