package zadKalkulator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<String, Dzialanie> dzialania = new HashMap<>();
    private String dzialanie;
    private double arg1;
    private double arg2;

    public Calculator() {
        dzialania.put("+", new Dodawanie());
        dzialania.put("-", new Odejmowanie());
        dzialania.put("*", new Mnozenie());
        dzialania.put("/", new Dzielenie());
    }

    public double calculate(String dzialanie, double arg1, double arg2){
        return dzialania.get(dzialanie).licz(arg1, arg2);
    }


}
