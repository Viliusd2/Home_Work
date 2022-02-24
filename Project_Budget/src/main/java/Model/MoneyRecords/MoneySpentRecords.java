package Model.MoneyRecords;

import Model.ParameterClasses.PaymentCategory;
import Model.ParameterClasses.PaymentMethods;
import Model.ParameterClasses.PaymentCards;
import Model.ParameterClasses.RecordType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MoneySpentRecords extends MoneyRecords {

  private final LocalDateTime date;
  private final PaymentMethods PaymentType;
  private final PaymentCards BankCardUsed;
  private final String category;

  public MoneySpentRecords(double sum, PaymentMethods paymentType, PaymentCards bankCardUsed, String papInfo) {
    super(sum, RecordType.SPENDING, papInfo);
    this.PaymentType = paymentType;
    this.date = LocalDateTime.now();
    this.BankCardUsed = bankCardUsed;
    this.category = PaymentCategory.getCategories();
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format(
            "Payment Type: %s\nCard used %s\nDate = %s\nCategory : %s\n\n",
            PaymentType, BankCardUsed, date, category);
  }
}
