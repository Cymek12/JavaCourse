package zadanie13;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class Smartfon extends Komorka{
    private List<Osoba> znajomi;

    public Smartfon(String interfejsKomunikacyjny, Color color, List<Osoba> znajomi) {
        super(interfejsKomunikacyjny, color);
        this.znajomi = znajomi;
    }

    @Override
    public void zadzwon(String numer){
        historiaPolaczen.add(numer);
    }

    @Override
    public void wyswietlHistoriePolaczen(){
        historiaPolaczen.stream()
                        .map(s -> formatNumber(s))
                        .forEach(System.out::println);
    }

    private String formatNumber(String number){
        Optional<String> matchPerson = znajomi.stream()
                .filter(s -> s.getNumer().equals(number))
                .map(s -> s.getImie() + " " + s.getNazwisko() + " " + s.getNumer())
                .findAny();
        return matchPerson.orElse(number);
    }
}
