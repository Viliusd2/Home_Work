package Model.Records;

import Model.ParameterClasses.Enums.PaymentRecordType;
import lombok.Getter;
import lombok.Setter;

@Getter

public class MoneyRecords {
  private final double sum;
  private final PaymentRecordType paymentRecordType;
  private final String papInfo;
  private final int id;
  private static int counter = 0;

  public MoneyRecords(double sum, PaymentRecordType paymentRecordType, String papInfo) {
    this.sum = sum;
    this.paymentRecordType = paymentRecordType;
    this.papInfo = papInfo;
    this.id = counter;
    counter++;
  }

  @Override
  public String toString() {
    return String.format(
        " MoneyRecords : Type: %s\n Sum = %.2f  Info : %s\n", paymentRecordType, sum, papInfo);
  }
}
