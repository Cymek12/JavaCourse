package RachunkiBankowe;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rachunek> rachunki = new ArrayList<>();
        rachunki.add(new Konto(new Osoba("Adam", "Wąsik", "Mężczyzna", 28), 15300.00));
        rachunki.add(new Konto(new Osoba("Paulina", "Nowakowska", "Kobieta", 22), 25300.00));
        rachunki.add(new KontoVIP(new Osoba("Zbigniew", "Mina", "Mężczyzna", 53), 35300.00, 0.08, -2000));
        rachunki.add(new KontoVIP(new Osoba("Monika", "Rolnik", "Kobieta", 36), 5300.00, 0.1, -1000));


        System.out.println("Zbigniew wplata");
        System.out.println(rachunki.get(2).wplata(500.00));

        System.out.println("Adam wyplata");
        System.out.println(rachunki.get(0).wyplata(200.00));

        System.out.println("Monika przelew do Adama");
        System.out.println(rachunki.get(3).przelew(rachunki.get(0), 2000.0));

        rachunki.forEach(s -> s.aktualizacja());
        rachunki.forEach(System.out::println);


    }
}
