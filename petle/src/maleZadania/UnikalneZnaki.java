package maleZadania;

import java.util.Scanner;

public class UnikalneZnaki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String unikalneZnaki = "`~!@#$%^&*()_-+={[]}:;<,>.?/|'\"\\";
        char[] tablicaUnikalnychZnakow = unikalneZnaki.toCharArray();

        System.out.println("Wprowadz haslo");
        String password = scanner.nextLine();
        char[] charPassword = password.toCharArray();

        czyMaUnikalneZnaki(tablicaUnikalnychZnakow, charPassword);

    }

    static void czyMaUnikalneZnaki(char[] tab1, char[] tab2){
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab2.length; j++) {
                int compare = Character.compare(tab1[i], tab2[j]);
                if(compare == 0){
                    System.out.println("Haslo ma unikalne znaki");
                    return;
                }
            }
        }
        System.out.println("Haslo nie ma unikalnych znakow");
    }
}
