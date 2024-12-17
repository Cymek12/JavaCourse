package zadanie13;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Komorka extends Telefon{
    protected List<String> historiaPolaczen = new ArrayList<>();


    public Komorka(String interfejsKomunikacyjny, Color color) {
        super(interfejsKomunikacyjny, color);
    }

    @Override
    public void zadzwon(String numer){
        historiaPolaczen.add(numer);
    }

    @Override
    public void wyswietlHistoriePolaczen(){
        System.out.println("Lista ostatnio wybranych numerów:");
        for (String s : historiaPolaczen) {
            System.out.println(s);
        }
    }
}
