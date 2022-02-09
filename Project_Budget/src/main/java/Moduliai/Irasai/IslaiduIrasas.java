package Moduliai.Irasai;

import Moduliai.FinalParameters.PaymentMethods;
import Moduliai.FinalParameters.BankCards;
import Moduliai.FinalParameters.PaymentCategory;

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
  private double sum;
  private final PaymentCategory Category = PaymentCategory.ISLAIDOS;
  private LocalDateTime date;
  private final PaymentMethods PaymentType;
  private final BankCards BankCardUsed;
  private String extraInfo;

  public IslaiduIrasas(
          double sum, PaymentMethods paymentType, BankCards bankCardUsed, String extraInfo) {
    this.sum = sum;
    this.PaymentType = paymentType;
    this.BankCardUsed = bankCardUsed;
    this.date = LocalDateTime.now();
    this.extraInfo = extraInfo;
  }

  public double getSum() {
    return sum;
  }

  public PaymentCategory getCategory() {
    return Category;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public PaymentMethods getPaymentType() {
    return PaymentType;
  }

  public BankCards getBankCardUsed() {
    return BankCardUsed;
  }

  public String getExtraInfo() {
    return extraInfo;
  }

  @Override
  public String toString() {
    return "Category = "
        + Category
        + "\nSuma = "
        + sum
        + "\nPayment Type = "
        + PaymentType
        + "\nBank Card Used = "
        + BankCardUsed
        + "\nDate = "
        + date
        + "\nPap Info = '"
        + extraInfo
        + "\n";
  }
}
