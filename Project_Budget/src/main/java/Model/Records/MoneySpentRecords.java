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
  private final LocalDateTime date;
  private final PaymentMethods PaymentMethod;
  private final PaymentCards BankCardUsed;
  private final String category;

  public MoneySpentRecords(
          double sum,
          PaymentMethods paymentMethod,
          PaymentCards bankCardUsed,
          String papInfo,
          String category) {
    super(sum, PaymentRecordType.SPENDING, papInfo);
    this.PaymentMethod = paymentMethod;
    this.date = LocalDateTime.now();
    this.BankCardUsed = bankCardUsed;
    this.category = category;
  }

  public MoneySpentRecords(
      double sum,
      PaymentMethods paymentMethod,
      PaymentCards bankCardUsed,
      String papInfo,
      String category,
      LocalDateTime date) {
    super(sum, PaymentRecordType.SPENDING, papInfo);
    this.PaymentMethod = paymentMethod;

    this.BankCardUsed = bankCardUsed;
    this.category = category;
    this.date = date;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return super.toString()
        + String.format(
            "Payment Type: %s\nCard used %s\nDate = %s\nCategory : %s\n\n",
            PaymentMethod, BankCardUsed, date.format(formatter), category);
  }
}
