package zadanie5;

public class ItemIsUnavailableException extends Exception{
    public ItemIsUnavailableException() {
        super("Item is unavailable");
    }
}
