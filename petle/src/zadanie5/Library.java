package zadanie5;

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

    public void borrowItemByTitle(String title) throws ItemIsUnavailableException, ItemDoesNotExistException {
        Optional<LibraryItem> optLibraryItem = findItemByTitle(title);

        if(optLibraryItem.isPresent()){
            optLibraryItem.get().borrowItem();
        }
        else {
            System.out.println("Tytuł nie istnieje");
        }
    }

    public void returnItemToLibrary(String title) throws ItemDoesNotExistException {
        Optional<LibraryItem> optLibraryItem = findItemByTitle(title);

        if(optLibraryItem.isPresent()){
            optLibraryItem.get().returnItem();
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
        return LibraryItem.countItems;
    }


}
