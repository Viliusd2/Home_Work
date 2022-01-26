package Namu_Darbai_01_04;



import java.util.Scanner;

public class Task5 {
    /*
    Klasės main metode sukurit masyvą Striing[] menesiai. Jį užpildyti metų mėnesių pavadinimais.a.
    Išvesti į ekraną
    i.masyvo dydį;
    ii.masyvo pirmą reikšmę.elementą
    iii.masyvo paskutini elementą
    b.Paprašyti vartotojo įvesti skačių nuo 1 iki 12.
    Pasinauduoti: Scanner scanner = newScanner(System.in);  int sk1 = scanner.nextInt();
    c.Išspasudinti i.pasirinktą mėnesio pavadinimąii.
    *išspausdinti prieš pasirinktą mėnesį einančio mėnesio pavadinimą ir po pasirinkto - mėnesio pavadinimą.
    Jei įvestas skaičius 1-12 visada turime gauti rezultatą be klaidų.
    P.S. po gruodžio eina sausis, prieš sausį buvęs mėnuo yra gruodis.:)
     */
    public static void main(String[] args) {
        String [] menesiai = {"Sausis", "Vasaris", "Kovas", "Balandis", "Geguze", "Birzelis","Liepa", "Rugpjutis", "Rugsejis", "Spalis", "Lapkritis", "Gruodis"};
        System.out.println("Masyvo ilgis: " + menesiai.length);
        System.out.println("Pirma reiksme: " + menesiai[0]);
        System.out.println("Paskutine reiksme: " + menesiai[menesiai.length-1]);

        Scanner scan = new Scanner(System.in);
        System.out.println("Iveskite sveikaji skaiciu nuo 1 iki 12 : ");

        int counter = 0;
        while  (counter>=0) {
            int sk1 = scan.nextInt();

            if (sk1 == 0 || sk1 > 12) {
                System.out.println("Bandykite is naujo skaicius yra netinkamas.");
            } else {
                System.out.printf("Pasirinktas menuo yra: %s\n",menesiai[sk1 - 1]);
                if(sk1==12){
                    System.out.printf("Einamasis menuo: %s , sekantis menuo: %s.\n", menesiai[sk1 - 1],menesiai[0]);
                }else {
                    System.out.printf("Einamasis menuo: %s , sekantis menuo: %s.\n", menesiai[sk1 - 1],menesiai[sk1]);
                }
                --counter;
            }
        }
    }
}
