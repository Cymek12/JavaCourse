package christmasHomework.maleZadania.role;

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


