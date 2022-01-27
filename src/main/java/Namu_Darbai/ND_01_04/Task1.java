package Namu_Darbai.ND_01_04;

public class Task1 {
    /*
    Sukurti klasę Task1 su main metodu.
    Sukurti dar vieną statinį metodą, kuris išspausdina perduotą tekstinę reikšmę.a.
    Pvz .: panaudojimas main metode:
    1.<jusu metodo pavadinimas>(“Vienas”);
    2.String tekstas = “Du”;
    3.<jusu metodo pavadinimas>(tekstas);
    ii.Rezultatas konsolėje: 1.>Vienas2.>Du
     */
    public static void print(String text) {
        System.out.println(">" + text);
    }

    public static void main(String[] args) {
        print("Vienas");
        String text = "Du";
        print(text);

    }
}
