package christmasHomework.maleZadania.role;

import java.util.List;

public class Uzytkownicy{
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