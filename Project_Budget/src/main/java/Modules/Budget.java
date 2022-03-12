package Modules;

import Modules.MoneyRecords.MoneySpent;
import Modules.MoneyRecords.MoneyEarned;

import java.util.ArrayList;

public class Budget {
  private final ArrayList<MoneyEarned> moneyEarned = new ArrayList<>();
  private final ArrayList<MoneySpent> moneySpent = new ArrayList<>();
  private double moneyBalance;

  public void addMoneyEarnedRecord(MoneyEarned pajamos) {
    this.moneyEarned.add(pajamos);
    moneyBalance += pajamos.getSum();
  }

  public void addMoneySpentRecord(MoneySpent islaidos) {
    this.moneySpent.add(islaidos);
    moneyBalance -= islaidos.getSum();
  }

  public ArrayList<MoneyEarned> getMoneyEarned() {
    return moneyEarned;
  }

  public ArrayList<MoneySpent> getMoneySpent() {
    return moneySpent;
  }

  public void getMoneyBalance() {
    System.out.printf("Money Balance at the moment = %.2f\n", moneyBalance);
  }
}
