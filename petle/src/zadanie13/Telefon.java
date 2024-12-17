package zadanie13;

import java.awt.*;

public class Telefon {
    protected String interfejsKomunikacyjny;
    protected Color color;

    public Telefon(String interfejsKomunikacyjny, Color color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    public void zadzwon(String numer){
        System.out.println("Dzwonie pod numer: " + numer);
    }

    public void wyswietlHistoriePolaczen(){
        System.out.println("Brak historii");
    }
}
