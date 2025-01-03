package wypozyczalnia.control;

import wypozyczalnia.exceptions.ItemIsUnavailableException;
import wypozyczalnia.model.LibraryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private List<LibraryItem> libraryItems = new ArrayList<>();


    public void addLibraryItem(LibraryItem libraryItem){
        libraryItems.add(libraryItem);
    }

    public void printAllItems(){
        printAvailableItems();
        printUnavailableItems();
    }

    public void printAvailableItems(){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.isAvailable()){
                System.out.println(libraryItem);
            }
        }
    }

    public void printUnavailableItems(){
        for (LibraryItem libraryItem : libraryItems) {
            if(!libraryItem.isAvailable()){
                System.out.println(libraryItem);
            }
        }
    }

    public void borrowItemByTitle(String title){
        Optional<LibraryItem> optLibraryItem = findItemByTitle(title);

        if(optLibraryItem.isPresent()){
            try {
                optLibraryItem.get().borrowItem();
                System.out.println("Udało się wypożyczyć tytuł");
            } catch (ItemIsUnavailableException e) {
                System.out.println("Tytuł nie jest dostępny do wypożyczenia");
            }
        }
        else {
            System.out.println("Tytuł nie istnieje");
        }
    }

    public void returnItemToLibrary(String title) {
        Optional<LibraryItem> optLibraryItem = findItemByTitle(title);

        if(optLibraryItem.isPresent()){
            optLibraryItem.get().returnItem();
            System.out.println("Udało się oddać tytuł do biblioteki");
        }
        else {
            System.out.println("Tytuł nie istnieje");
        }
    }

    private Optional<LibraryItem> findItemByTitle(String tiile){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.getTitle().equals(tiile)){
                return Optional.of(libraryItem);
            }
        }
        return Optional.empty();
    }

    public int getNumberOfItems(){
        return LibraryItem.getCountItems();
    }


}
