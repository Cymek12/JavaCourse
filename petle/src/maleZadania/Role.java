package maleZadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Role {
    public static void main(String[] args) {
        List<Uzytkownicy> uzytkownicy = new ArrayList<>();
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));
        uzytkownicy.add(new Uzytkownicy(new ArrayList<>()));

        Set<String> set = uzytkownicy.stream()
                .flatMap(s -> s.getRole().stream())
                .collect(Collectors.toSet());
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
