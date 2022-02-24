package Model.MoneyRecords;

import Model.ParameterClasses.RecordType;
import lombok.Getter;

@Getter
public class MoneyRecords {
  private final double sum;
  private final RecordType recordType;
  private final String papInfo;
  private final int id;
  private static int counter = 0;

  public MoneyRecords(double sum, RecordType recordType, String papInfo) {
    counter++;
    this.sum = sum;
    this.recordType = recordType;
    this.papInfo = papInfo;
    this.id = counter;
  }

  @Override
  public String toString() {
    return String.format(
        "%d || MoneyRecords : Type: %s\n Sum = %.2f  Info : %s\n", id, recordType, sum, papInfo);
  }
}
