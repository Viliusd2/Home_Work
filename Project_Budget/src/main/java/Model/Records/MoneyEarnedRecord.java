package Model.Records;

import Model.ParameterClasses.Enums.PaymentRecordType;
import lombok.Getter;


import java.io.Serializable;
import java.time.LocalDate;

@Getter

public class MoneyEarnedRecord extends MoneyRecords implements Serializable {

  private final LocalDate moneyTransferDate;
  private final boolean successfulTransfer;

  public MoneyEarnedRecord(double moneyAmount, boolean successfulTransfer, String papInfo) {
    super(moneyAmount, PaymentRecordType.INCOME, papInfo);
    this.moneyTransferDate = LocalDate.now();
    this.successfulTransfer = successfulTransfer;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format("Date = %s " + "\nTransfer success = %s\n\n", moneyTransferDate, successfulTransfer);
  }
}
