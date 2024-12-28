package maleZadania;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UtworzPlik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku do stworzenia");
        String fileName = scanner.nextLine();
        boolean result = false;
        try {
            result = utworzPlik(fileName);
        } catch (IOException e) {
            System.out.println("Runtime exception");
        } finally {
            System.out.println(result);
        }

    }

    static boolean utworzPlik(String fileName) throws IOException {
        File file = new File(fileName);
        return file.createNewFile();

    }
}
