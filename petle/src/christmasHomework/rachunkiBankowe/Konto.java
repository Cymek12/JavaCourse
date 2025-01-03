package christmasHomework.rachunkiBankowe;

public class Konto extends Rachunek{
    private static double oprocentowanie = 0.04;

    public Konto(Osoba wlasciciel, double saldo) {
        super(wlasciciel, saldo);
    }

    public static double getOprocentowanie() {
        return oprocentowanie;
    }

    public static void zmienOprocentowanie(double noweOprocentowanie){
       oprocentowanie = noweOprocentowanie;
    }

    @Override
    public void aktualizacja() {
        setSaldo(getSaldo() * (1 + oprocentowanie));
    }

    @Override
    public String toString() {
        return super.toString() + " oprocentowanie: " + oprocentowanie;
    }
}
