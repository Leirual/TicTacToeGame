package pl.codeme.jse1.gra;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Podaj liczby z przedziału 0 - 5");
        Scanner scanner = new Scanner(System.in);
        int liczba = Integer.valueOf(scanner.nextLine());
        String tekst;
        switch(liczba) {
            case 0:
                tekst = "zero";
                break;
            case 1:
                tekst = "jeden";
                break;
            case 2:
                tekst = "dwa";
                break;
            case 3:
                tekst = "trzy";
                break;
            case 4:
                tekst = "cztery";
                break;
            case 5:
                tekst = "pięć";
                break;
            default:
                tekst = "podaj odpowiednia liczbe";
        }
        System.out.println("ze switch " + tekst);

        scanner.close();
    }

}
