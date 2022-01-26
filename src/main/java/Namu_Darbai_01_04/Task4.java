package Namu_Darbai_01_04;

import java.util.Scanner;

public class Task4 {
    /*
    Klasė Task4, main metode paprašyti vartotojo įvesti tekstą-sakinį ir priskirti kintamajam text.
    a.panaudojant įvestą teksto reikšmę išspausdinti:
    i.viską didžiosiomis raidėmis
    ii.išvesti įvesto teksto ilgį
    iii.išspausdinti įvesto teksto paskutinį žodį (panaudoti: lastIndexOf)
    iv.visas raides a pakeitus į Wv.visas raides e pakeitus į RAIDE
    vi.sukeisti pirmą sakinio žodį su paskutiniu sakinio žodžiub.teksto įvedimui pasinaudoti:
    c.Scanner scanner = new Scanner(System.in);
    d.String t = scanner.nextLine();
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sveiki. Iveskite teksta - sakini: ");
        String text = scan.nextLine();

        System.out.println("Change to upper case: " + text.toUpperCase());
        System.out.println("Text length: " + text.length());
        System.out.println("Last word in text: " + text.substring(text.lastIndexOf(" ")));
        System.out.println("Change of letters a to w : " + text.replace('a', 'w'));
        System.out.println("Change of e to RAIDE: " + text.replace("e", "RAIDE"));
        String textWordSwap = text.substring(text.lastIndexOf(" ")) + text.substring(text.indexOf(" "), text.lastIndexOf(" ") + 1) + text.substring(0, text.indexOf(" "));
        System.out.println("First and last word changed places via .substring : " + textWordSwap);

    }
}
