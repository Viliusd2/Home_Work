package Moduliai.Irasai;

import Moduliai.FinalParameters.PaymentCategory;

import java.time.LocalDate;

public class PajamuIrasas {
  private double suma;
  private final PaymentCategory Category = PaymentCategory.PAJAMOS;
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

  public PaymentCategory getCategory() {
    return Category;
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
    return "Category = "
        + Category
        + "\nSuma = "
        + suma
        + "\nDate = "
        + date
        + "\nAr Pinigai Gauti = "
        + arPinigaiGauti
        + "\nPap Info = '"
        + papInfo
        + "\n";
  }
}
