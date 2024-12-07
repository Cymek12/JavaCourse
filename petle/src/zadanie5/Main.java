package zadanie5;

import java.util.Scanner;

public class Main {
    static final int PRINT_ALL_ITEMS = 1;
    static final int BORROW_ITEM_BY_TITLE = 2;
    static final int RETURN_ITEM_BY_TITLE = 3;
    static final int PRINT_NUMBER_OF_ITEMS = 4;
    static final int EXIT = 5;

    public static void main(String[] args) {
        Library library = new Library();
        library.addLibraryItem(new Book("Krzyzacy", "Sienkiewicz", 500));
        library.addLibraryItem(new Book("Rozdroże kruków", "Sapkowski", 350));
        library.addLibraryItem(new Book("Cienie pośród mroku", "Mróz", 410));
        library.addLibraryItem(new Movie("Lista Schindlera", "Steven Spielberg", 180));
        library.addLibraryItem(new Movie("Lśnienie", "Stanley Kubric", 130));
        library.addLibraryItem(new Movie("Bękarty wojny", "Quentin Tarantino", 200));

        Scanner scanner = new Scanner(System.in);

        int option;
        boolean exit = false;
        while (!exit){
            optionMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1 -> library.printAllItems();
                case 2 -> {
                    System.out.println("Podaj tytuł który chcesz wypożyczyć:");
                    String title = scanner.nextLine();

                    try {
                        library.borrowItemByTitle(title);
                    } catch (ItemIsUnavailableException | ItemDoesNotExistException e) {
                        System.out.println("Tytuł nie istnieje lub jest wypożyczony");
                    }
                }
                case 3 -> {
                    System.out.println("Podaj tytuł których chesz zwrócić");
                    String title = scanner.nextLine();
                    try {
                        library.returnItemToLibrary(title);
                    } catch (ItemDoesNotExistException e) {
                        System.out.println("Tytuł nie istnieje");
                    }
                }
                case 4 -> System.out.println("Liczba elementów w bibliotece to: " + library.getNumberOfItems());
                case 5 -> exit = true;
                default -> System.out.println("Brak dostępnej opcji, spróbuj ponownie");
            }
        }

    }

    static void optionMenu(){
        System.out.println("Wybierz opcję:");
        System.out.println(PRINT_ALL_ITEMS + " - Wyświetl listę dostępnych i wypożyczonych elementów");
        System.out.println(BORROW_ITEM_BY_TITLE + " - Wypożycz element po tytule");
        System.out.println(RETURN_ITEM_BY_TITLE + " - Zwróć do biblioteki element po tytule");
        System.out.println(PRINT_NUMBER_OF_ITEMS + " - Wyświetl liczbę książek i filmów w systemie");
        System.out.println(EXIT + " - Wyjście z programu");
    }

}
