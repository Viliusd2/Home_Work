package Modules;

import Modules.MoneyRecords.MoneyRecords;
import Modules.MoneyRecords.MoneySpentRecords;
import Modules.MoneyRecords.MoneyEarnedRecord;

import java.util.ArrayList;

public class Budget {
  private final ArrayList<MoneyRecords> moneyRecords = new ArrayList<>();
  private double moneyBalance;

  public void addMoneyEarnedRecord(MoneyEarnedRecord pajamos) {
    this.moneyRecords.add(pajamos);
    moneyBalance += pajamos.getSum();
  }

  public void addMoneySpentRecord(MoneySpentRecords islaidos) {
    this.moneyRecords.add(islaidos);
    moneyBalance -= islaidos.getSum();
  }

  public ArrayList<MoneyRecords> getMoneyRecords() {
    return moneyRecords;
  }

  public void getMoneyBalance() {
    System.out.printf("Money Balance at the moment = %.2f\n", moneyBalance);
  }
}
