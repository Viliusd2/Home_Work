package Namu_Darbai_01_04;

import java.util.Scanner;

public class Task3 {
    /*
    Klasė Task3, kuri main metode paprašytų įvesti 5 kartus bet kokį sveiką skaičių ir išspausdintų suvestų skaičių sumą.
    a.Pasinaudojant:  Scanner scanner = new Scanner(System.in);
    b.int sk1 = scanner.nextInt();
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Suveskite reikalaujamus duomenis.");
        int rezultatas = 0;

        for (int i = 1; i < 6; i++) {
            System.out.printf("Iveskite %d-a sveikaji skaiciu: ", i);
            rezultatas += scan.nextInt();
        }
        System.out.println("Ivestu skaiciu suma lygi: " + rezultatas);
    }
}
