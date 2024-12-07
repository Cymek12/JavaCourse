package zadanie5;

public class ItemDoesNotExistException extends Exception{
    public ItemDoesNotExistException() {
        super("Item does not exist");
    }
}
