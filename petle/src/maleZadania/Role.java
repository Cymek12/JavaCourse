package maleZadania;

import java.util.ArrayList;
import java.util.List;

public class Role {
    public static void main(String[] args) {
        List<Uzytkownicy> uzytkownicy = new ArrayList<>();
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));

        List<String> list = uzytkownicy.stream()
                .flatMap(s -> s.getRole().stream())
                .toList();
    }
}

class Uzytkownicy{
    private List<String> role;

    public Uzytkownicy(List<String> role) {
        this.role = role;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
