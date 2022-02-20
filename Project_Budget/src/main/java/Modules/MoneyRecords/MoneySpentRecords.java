package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentMethods;
import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentCategory;

import java.time.LocalDateTime;

public class MoneySpentRecords extends MoneyRecords{


  private final LocalDateTime date;
  private final PaymentMethods PaymentType;
  private final BankCards BankCardUsed;


  public MoneySpentRecords(double sum, PaymentMethods paymentType,BankCards bankCardUsed, String papInfo) {
    super(sum, PaymentCategory.SPENDINGS, papInfo);
    this.PaymentType = paymentType;
    this.date = LocalDateTime.now();
    this.BankCardUsed = bankCardUsed;

  }
  @Override
  public String toString() {
    return super.toString() + String.format(
            "\nPayment Type: %s\nCard used %s\nDate = %s\n",
             PaymentType,BankCardUsed, date);
  }
}
