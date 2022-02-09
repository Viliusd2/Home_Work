package Moduliai.Irasai;

import Moduliai.TypeOfRecord;

import java.time.LocalDate;


public class PajamuIrasas {
    private double suma;
    private final TypeOfRecord TYPE =  TypeOfRecord.PAJAMOS;
    private LocalDate date;
    private boolean arPinigaiGauti;
    private String papInfo;

    public PajamuIrasas(double suma, LocalDate date, boolean arPinigaiGauti, String papInfo) {
        this.suma = suma;
        this.date = date;
        this.arPinigaiGauti = arPinigaiGauti;
        this.papInfo = papInfo;
    }
}
