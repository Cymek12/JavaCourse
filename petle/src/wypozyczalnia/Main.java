package wypozyczalnia;

import wypozyczalnia.control.Library;
import wypozyczalnia.model.Book;
import wypozyczalnia.model.Movie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = createSampleLibrary();

        int option;
        boolean exit = false;
        while (!exit){
            System.out.println("Wybierz opcję:");
            System.out.println("1 - Wyświetl listę dostępnych i wypożyczonych elementów");
            System.out.println("2 - Wypożycz element po tytule");
            System.out.println("3 - Zwróć do biblioteki element po tytule");
            System.out.println("4 - Wyświetl liczbę książek i filmów w systemie");
            System.out.println("5 - Wyjście z programu");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1 -> library.printAllItems();
                case 2 -> {
                    System.out.println("Podaj tytuł który chcesz wypożyczyć:");
                    String title = scanner.nextLine();
                    library.borrowItemByTitle(title);
                }
                case 3 -> {
                    System.out.println("Podaj tytuł których chesz zwrócić");
                    String title = scanner.nextLine();
                    library.returnItemToLibrary(title);
                }
                case 4 -> System.out.println("Liczba elementów w bibliotece to: " + library.getNumberOfItems());
                case 5 -> exit = true;
                default -> System.out.println("Brak dostępnej opcji, spróbuj ponownie");
            }
        }

        scanner.close();
    }

    private static Library createSampleLibrary(){
        Library library = new Library();
        library.addLibraryItem(new Book("Krzyzacy", "Sienkiewicz", 500));
        library.addLibraryItem(new Book("Rozdroże kruków", "Sapkowski", 350));
        library.addLibraryItem(new Book("Cienie pośród mroku", "Mróz", 410));
        library.addLibraryItem(new Movie("Lista Schindlera", "Steven Spielberg", 180));
        library.addLibraryItem(new Movie("Lśnienie", "Stanley Kubric", 130));
        library.addLibraryItem(new Movie("Bękarty wojny", "Quentin Tarantino", 200));
        return library;
    }
}
