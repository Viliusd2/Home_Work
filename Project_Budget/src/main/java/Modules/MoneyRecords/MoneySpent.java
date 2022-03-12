package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentMethods;
import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentCategory;

import java.time.LocalDateTime;

public class MoneySpent {
  /*
  Sukurti dvi klases: PajamuIrasas, IslaiduIrasas. Šios dvi klasės apjungspajamų, išlaidų informaciją.
   T.y. atliekant operaciją "įvesti pajamas" bus sukuriamas naujas PajamuIraso objektas,
    kuriame išsaugosime: [sumą], [kategorijosindeksą], [data],[požymį, ar pinigai gauti į banko sąskaitą],
    [papildomąinformaciją]. Sukurtą objektą padėsime į pajamų masyvą. Analogiškai su išlaidomis...
    objekte išsaugo išlaidų operacijos susijusią informaciją: [suma], [kategorijosindeksas],
   [data su laiku], [atsiskaitymo būdas], [kokia banko kortele], [...]. Sukurtą objektą patalpinti į išlaidų masyvą.
   */
  private double sum;
  private final PaymentCategory Category = PaymentCategory.SPENDINGS;
  private LocalDateTime date;
  private final PaymentMethods PaymentType;
  private final BankCards BankCardUsed;
  private String extraInfo;

  public MoneySpent(
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
        + "\nSum = "
        + sum
        + "\nPayment Type = "
        + PaymentType
        + "\nBank Card Used = "
        + BankCardUsed
        + "\nDate = "
        + date
        + "\nExtra Info = '"
        + extraInfo
        + "\n";
  }
}
