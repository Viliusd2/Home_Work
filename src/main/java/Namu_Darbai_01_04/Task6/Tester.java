package Namu_Darbai_01_04.Task6;

public class Tester {
    /*
    6. Klasė: Telefonas (markė, modelis, atmintis, spalva)  parodyk();
    7. Klasė: Piniginė (eur100,eur50,eur20,eut10,eur5)parodyk();suma(); - suskaičiuoja
    8. Klase Skaiciuotuvas su metodais: sudeti, atimti, dauginti, dalinti, dalybosLiekana.
    9. Kas yra enum?10. Kas yra constructor?
    P.S. Visa informacija, kuri yra išvedama į konsolę, turi būti informatyvi, su paaiškinimu, ką išvedate, ar kokios reikšmės laukiate iš vartotojo.
    PVZ: Įveskite sveiką skaišiuo nuo 1 iki 10.
    P.SS. kopijuonant iš skaidrių kodo fragmentus, kartais kabutės nusikopijuoja netinkamo formato,
    todėl kabutes reikia ištriniti Eclipėje ir uždėti iš naujo.
     */
    public static void main(String[] args) {
        Pinigine pinigine = new Pinigine();
        pinigine.parodyk();
        pinigine.suma();
        System.out.println("-----------------------------");

        Telefonas tel = new Telefonas();
        tel.setAtmintis();
    }
}
