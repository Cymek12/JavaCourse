package zadanie5;

public abstract class LibraryItem {
    protected boolean isAvailable = true;
    protected String title;
    protected static int countItems;

    public LibraryItem(String title) {
        this.title = title;
        countItems++;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public int getCountItems() {
        return countItems;
    }

    public void borrowItem() throws ItemIsUnavailableException {
        if(isAvailable){
            setAvailable(false);
        }else {
            throw new ItemIsUnavailableException();
        }
    }

    public void returnItem(){
        if(!isAvailable){
            setAvailable(true);
        }else {
            System.out.println("Tytuł jest już oddany do biblioteki");
        }
    }



}
