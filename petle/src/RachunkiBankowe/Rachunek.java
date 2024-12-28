package RachunkiBankowe;

public class Rachunek {
    private Osoba wlasciciel;
    private double saldo;

    public Rachunek(Osoba wlasciciel, double saldo) {
        this.wlasciciel = wlasciciel;
        this.saldo = saldo;
    }

    public Osoba getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Osoba wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Rachunek{" +
                "wlasciciel=" + wlasciciel +
                ", saldo=" + saldo +
                '}';
    }

    public void aktualizacja(){
        System.out.println("Rachunek podstawowy");
    }

    public boolean przelew(Rachunek rachunekOdbiorcy, double kwota){
        if(rachunekOdbiorcy != null && kwota > 0 && saldo >= kwota){
            rachunekOdbiorcy.saldo += kwota;
            saldo -= kwota;
            return true;
        }
        return false;
    }

    public boolean wplata(double kwotaWplacana){
        if(kwotaWplacana > 0){
            saldo += kwotaWplacana;
            return true;
        }

        return false;
    }

    public boolean wyplata(double kwotaWyplacana){
        if(saldo >= kwotaWyplacana && kwotaWyplacana > 0){
            saldo -= kwotaWyplacana;
            return true;
        }
        return false;
    }
}
