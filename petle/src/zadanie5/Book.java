package zadanie5;

public class Book extends LibraryItem{
    static int bookCounter;
    private String author;
    private int pageNumber;

    public Book(String title, String author, int pageNumber) {
        super(title);
        this.author = author;
        this.pageNumber = pageNumber;
        //bookCounter++;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Tytuł: " + title +
                ", Autor: " + author +
                ", Liczba stron: " + pageNumber +
                ", Czy dostępny: " + isAvailable;
    }
}