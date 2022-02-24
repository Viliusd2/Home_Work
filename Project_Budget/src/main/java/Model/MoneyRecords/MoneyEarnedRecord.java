package Model.MoneyRecords;

import Model.ParameterClasses.RecordType;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MoneyEarnedRecord extends MoneyRecords {

  private LocalDate date;
  private final boolean successfulTransfer;

  public MoneyEarnedRecord(double sum, boolean successfulTransfer, String papInfo) {
    super(sum, RecordType.INCOME, papInfo);
    this.date = LocalDate.now();
    this.successfulTransfer = successfulTransfer;
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format("Date = %s " + "\nTransfer success = %s\n\n", date, successfulTransfer);
  }
}
