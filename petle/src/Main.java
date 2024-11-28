import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char exit = 'y';
        double result = 0.0;

        while (exit == 'y'){
            System.out.println("Podaj pierwszą liczbę: ");
            double a = scanner.nextDouble();
            System.out.println("Co chcesz zrobić? (+, -, *, /, %, ^");
            String znak = scanner.next();
            System.out.println("Podaj drugą liczbę: ");
            double b = scanner.nextDouble();

            result = switch (znak){
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> {
                    if(b == 0){
                        System.out.println("Nie można dzielić przez 0");
                        yield Double.NaN;
                    }
                    else {
                        yield a / b;
                    }
                }
                case "%" -> a % b;
                case "^" -> Math.pow(a, b);
                default -> {
                    System.out.println("Podano zły operator");
                    yield Double.NaN;
                }
            };

            if (!Double.isNaN(result)) {
                System.out.println("Wynik z operacji " + a + " " + znak + " " + b + " = " + result);
            }

            System.out.println("Czy chcesz wykonać kolejne działanie? (y/n).");
            String example = scanner.next();
            exit = example.charAt(0);
        }

        String nieparzysta = "Liczba z ostatniego wyniku jest nieparzysta";
        String parzysta = "Liczba z ostatniego wyniku jest parzysta";

        if (!Double.isNaN(result)) {
            System.out.println(result % 2 == 1 ? nieparzysta : parzysta);
        }
    }
}