package wypozyczalnia.exceptions;

public class ItemIsUnavailableException extends Exception{
    public ItemIsUnavailableException() {
        super("Item is unavailable");
    }
}
