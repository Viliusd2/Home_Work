package Model.Records;

import Model.ParameterClasses.Enums.PaymentRecordType;
import lombok.Getter;

import java.io.Serializable;


@Getter

public class MoneyRecords implements Serializable {
  private final double moneyAmount;
  private final PaymentRecordType paymentRecordType;
  private final String commentForRecord;
  private final int id;
  private static int counter = 0;

  public MoneyRecords(double moneyAmount, PaymentRecordType paymentRecordType, String commentForRecord) {
    this.moneyAmount = moneyAmount;
    this.paymentRecordType = paymentRecordType;
    this.commentForRecord = commentForRecord;
    this.id = counter;
    counter++;
  }

  @Override
  public String toString() {
    return String.format(
        " MoneyRecords : Type: %s\n Sum = %.2f  Info : %s\n", paymentRecordType, moneyAmount, commentForRecord);
  }
}
