package Moduliai.Irasai;

import Moduliai.TypeOfRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class IslaiduIrasas {
    /*
    Sukurti dvi klases: PajamuIrasas, IslaiduIrasas. Šios dvi klasės apjungspajamų, išlaidų informaciją.
     T.y. atliekant operaciją "įvesti pajamas" bus sukuriamas naujas PajamuIraso objektas,
      kuriame išsaugosime: [sumą], [kategorijosindeksą], [data],[požymį, ar pinigai gauti į banko sąskaitą],
      [papildomąinformaciją]. Sukurtą objektą padėsime į pajamų masyvą. Analogiškai su išlaidomis...
      objekte išsaugo išlaidų operacijos susijusią informaciją: [suma], [kategorijosindeksas],
     [data su laiku], [atsiskaitymo būdas], [kokia banko kortele], [...]. Sukurtą objektą patalpinti į išlaidų masyvą.
     */
    private double suma;
    private final TypeOfRecord TYPE = TypeOfRecord.ISLAIDOS;
    private LocalDateTime date;
    private String[] atskiskaitymoBudas = {"Credit","Card","Cash take out","ApplePay"};
    private String[] bankoKortele = {"Visa", "Debit","Mastercard","American Express"};
    private String papInfo;

    public IslaiduIrasas(double suma, String papInfo) {
        this.suma = suma;
        this.date = LocalDateTime.now();
        this.papInfo = papInfo;
    }

    public double getSuma() {
        return suma;
    }

    public TypeOfRecord getTYPE() {
        return TYPE;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String[] getAtskiskaitymoBudas() {
        return atskiskaitymoBudas;
    }

    public String[] getBankoKortele() {
        return bankoKortele;
    }

    public String getPapInfo() {
        return papInfo;
    }
    @Override
    public String toString() {
        return "Islaidu Irasas "
                + "\nSuma = "
                + suma
                + "\nTYPE = "
                + TYPE
                + "\nDate = "
                + date
                + "\nPap Info = '"
                + papInfo + "\n";
    }
}
