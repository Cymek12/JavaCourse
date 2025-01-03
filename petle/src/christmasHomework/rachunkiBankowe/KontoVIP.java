package christmasHomework.rachunkiBankowe;

public class KontoVIP extends Konto{
    private double oprocentowanie;
    private double limitDebetu;

    public KontoVIP(Osoba wlasciciel, double saldo, double oprocentowanie, double limitDebetu) {
        super(wlasciciel, saldo);
        this.oprocentowanie = oprocentowanie;
        this.limitDebetu = limitDebetu;
    }

    @Override
    public boolean wyplata(double kwotaWyplacana) {
        double maxWyplata = getSaldo() * (1 + oprocentowanie) - limitDebetu;
        if(maxWyplata >= kwotaWyplacana && kwotaWyplacana > 0){
            setSaldo(getSaldo() - kwotaWyplacana);
            return true;
        }
        return false;
    }

    @Override
    public void aktualizacja() {
        setSaldo(getSaldo() * (1 + oprocentowanie));
    }

    @Override
    public boolean przelew(Rachunek rachunekOdbiorcy, double kwota){
        double maxPrzelew = getSaldo() * (1 + oprocentowanie) - limitDebetu;
        if(rachunekOdbiorcy != null && kwota > 0 && maxPrzelew >= kwota){
            rachunekOdbiorcy.setSaldo(rachunekOdbiorcy.getSaldo() + kwota);
            setSaldo(getSaldo() - kwota);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "KontoVIP{" +
                "oprocentowanie=" + oprocentowanie +
                ", limitDebetu=" + limitDebetu +
                '}';
    }
}
