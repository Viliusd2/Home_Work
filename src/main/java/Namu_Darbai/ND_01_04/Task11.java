package Namu_Darbai.ND_01_04;

import java.util.Scanner;

public class Task11 {
    // Swapping string variables
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Iveskite pasirinkta texta: ");
        String text = scan.nextLine();
        /* String firstWord = text.substring(0,text.indexOf(' '));
         String lastWord = text.substring(text.lastIndexOf(' '));
        */
        text = text.substring(text.lastIndexOf(' ')+1) + text.substring(text.indexOf(' '), text.lastIndexOf(' ')+1) + text.substring(0, text.indexOf(' '));
        System.out.println(text);
    }
}
