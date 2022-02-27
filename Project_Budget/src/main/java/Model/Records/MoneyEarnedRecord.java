package Model.Records;

import Model.ParameterClasses.Enums.PaymentRecordType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter

public class MoneyEarnedRecord extends MoneyRecords {

  private final LocalDate date;
  private final boolean successfulTransfer;

  public MoneyEarnedRecord(double sum, boolean successfulTransfer, String papInfo) {
    super(sum, PaymentRecordType.INCOME, papInfo);
    this.date = LocalDate.now();
    this.successfulTransfer = successfulTransfer;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format("Date = %s " + "\nTransfer success = %s\n\n", date, successfulTransfer);
  }
}
