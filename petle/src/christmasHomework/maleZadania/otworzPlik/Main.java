package christmasHomework.maleZadania.otworzPlik;

public class Main {
    public static void main(String[] args){


        try {
            otworzPlik("test.pdf");
        } catch (UnsupportedFileFormatException e) {
            System.err.println(e.getMessage());
        }

        try {
            otworzPlik("test.txt");
        } catch (UnsupportedFileFormatException e) {
            System.err.println(e.getMessage());
        }


    }

    static void otworzPlik(String nazwaPliku) throws UnsupportedFileFormatException {
        if(!nazwaPliku.endsWith(".txt")){
            throw new UnsupportedFileFormatException("Nieobsługiwany format pliku: " + nazwaPliku);
        }
        System.out.println("Otwieram plik: " + nazwaPliku);
    }
}
