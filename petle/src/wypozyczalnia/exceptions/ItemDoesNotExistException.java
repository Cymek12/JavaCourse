package wypozyczalnia.exceptions;

public class ItemDoesNotExistException extends Exception{
    public ItemDoesNotExistException() {
        super("Item does not exist");
    }
}
