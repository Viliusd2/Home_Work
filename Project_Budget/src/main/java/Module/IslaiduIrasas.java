package Module;

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

    public IslaiduIrasas(double suma, LocalDateTime date, String papInfo) {
        this.suma = suma;
        this.date = date;
        this.papInfo = papInfo;
    }
}
