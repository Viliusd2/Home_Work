package Model;

import Model.MoneyRecords.MoneyRecords;
import Model.MoneyRecords.MoneySpentRecords;
import Model.MoneyRecords.MoneyEarnedRecord;
import Model.ParameterClasses.RecordType;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Budget {
  private final ArrayList<MoneyRecords> moneyRecords = new ArrayList<>();
  private double moneyBalance;

  public void addMoneyRecord(MoneyRecords moneyRecords) {
    this.moneyRecords.add(moneyRecords);
  }

  public void balanceCounter() {
    for (MoneyRecords moneyRecord : moneyRecords) {
      if (moneyRecord.getRecordType().equals(RecordType.INCOME)) {
        this.moneyBalance += moneyRecord.getSum();
      } else {
        this.moneyBalance -= moneyRecord.getSum();
      }
    }
  }

  public ArrayList<MoneyRecords> getMoneyRecords() {
    return moneyRecords;
  }

  public void getMoneyBalance() {
    balanceCounter();
    System.out.printf("Money Balance at the moment = %.2f\n", moneyBalance);
  }
}
