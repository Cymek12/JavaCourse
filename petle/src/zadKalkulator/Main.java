package zadKalkulator;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Calculator calculator = new Calculator();

        System.out.println("Wprowadz jedna z operacji: + - * /");
        String dzialanie = scanner.nextLine();

        System.out.println("Pierwsza liczba: ");
        double arg1 = scanner.nextDouble();

        System.out.println("Druga liczba: ");
        double arg2 = scanner.nextDouble();

        System.out.println("Wynik: ");
        System.out.format("%.2f",calculator.calculate(dzialanie, arg1, arg2));

    }
}
