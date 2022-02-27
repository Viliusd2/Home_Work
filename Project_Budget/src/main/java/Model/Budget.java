package Model;

import Model.ParameterClasses.Enums.PaymentRecordType;
import Model.Records.MoneyEarnedRecord;
import Model.Records.MoneyRecords;
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
      if (moneyRecord.getPaymentRecordType().equals(PaymentRecordType.INCOME)) {
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
