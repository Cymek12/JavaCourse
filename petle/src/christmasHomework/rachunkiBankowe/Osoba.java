package christmasHomework.rachunkiBankowe;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String plec;
    private int wiek;

    public Osoba(String imie, String nazwisko, String plec, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
