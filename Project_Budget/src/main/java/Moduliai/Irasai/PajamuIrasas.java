package Moduliai.Irasai;

import Moduliai.TypeOfRecord;

import java.time.LocalDate;

public class PajamuIrasas {
  private double suma;
  private final TypeOfRecord TYPE = TypeOfRecord.PAJAMOS;
  private LocalDate date;
  private boolean arPinigaiGauti;
  private String papInfo;

  public PajamuIrasas(double suma, String date, boolean arPinigaiGauti, String papInfo) {
    this.suma = suma;
    this.date = LocalDate.parse(date);
    this.arPinigaiGauti = arPinigaiGauti;
    this.papInfo = papInfo;
  }

  public double getSuma() {
    return suma;
  }

  public TypeOfRecord getTYPE() {
    return TYPE;
  }

  public LocalDate getDate() {
    return date;
  }

  public boolean isArPinigaiGauti() {
    return arPinigaiGauti;
  }

  public String getPapInfo() {
    return papInfo;
  }

  @Override
  public String toString() {
    return "PajamuIrasas "
        + "\nSuma = "
        + suma
        + "\nTYPE = "
        + TYPE
        + "\nDate = "
        + date
        + "\nAr Pinigai Gauti = "
        + arPinigaiGauti
        + "\nPap Info = '"
        + papInfo + "\n";
  }
}
