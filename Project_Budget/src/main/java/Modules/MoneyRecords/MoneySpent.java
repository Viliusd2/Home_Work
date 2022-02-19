package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentMethods;
import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentCategory;

import java.time.LocalDateTime;

public class MoneySpent {

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

    return String.format(
            "Category %s \nSum = %.2f\nPayment Type: %s\nCard Used: %s\nDate = %s\nExtra Info: %s\n",
            Category, sum, PaymentType, BankCardUsed, date, extraInfo);
  }
}
