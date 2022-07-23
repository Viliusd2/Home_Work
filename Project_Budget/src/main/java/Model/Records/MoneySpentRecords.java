package Model.Records;

import Model.ParameterClasses.Enums.PaymentMethods;
import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentRecordType;
import lombok.Getter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MoneySpentRecords extends MoneyRecords implements Serializable {
  private final LocalDateTime moneySpentDate;
  private final PaymentMethods PaymentMethod;
  private final PaymentCards BankCardUsed;
  private final String paymentCategory;

  public MoneySpentRecords(double paymentSum, PaymentMethods paymentMethod, PaymentCards bankCardUsed, String papInfo, String paymentCategory) {
    super(paymentSum, PaymentRecordType.SPENDING, papInfo);
    this.PaymentMethod = paymentMethod;
    this.moneySpentDate = LocalDateTime.now();
    this.BankCardUsed = bankCardUsed;
    this.paymentCategory = paymentCategory;
  }

  public MoneySpentRecords(
      double sum, PaymentMethods paymentMethod, PaymentCards bankCardUsed, String papInfo, String paymentCategory, LocalDateTime moneySpentDate) {
    super(sum, PaymentRecordType.SPENDING, papInfo);
    this.PaymentMethod = paymentMethod;
    this.BankCardUsed = bankCardUsed;
    this.paymentCategory = paymentCategory;
    this.moneySpentDate = moneySpentDate;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return super.toString()
        + String.format(
            "Payment Type: %s\nCard used %s\nDate = %s\nCategory : %s\n\n",
            PaymentMethod, BankCardUsed, moneySpentDate.format(formatter), paymentCategory);
  }
}
