package Modules;

import Modules.MoneyRecords.MoneySpent;
import Modules.MoneyRecords.MoneyEarned;

public class Budget {
  private MoneyEarned[] moneyEarned = new MoneyEarned[100];
  private MoneySpent[] moneySpent = new MoneySpent[100];
  private static int earnedCounter = 0;
  private static int spentCounter = 0;

  public void addMoneyEarnedRecord(MoneyEarned pajamos) {
      this.moneyEarned[earnedCounter] = pajamos;
      earnedCounter++;
  }

  public void addMoneySpentRecord(MoneySpent islaidos) {
    this.moneySpent[spentCounter] = islaidos;
    spentCounter++;
  }

  public void getEarningsRecord(int index) {
    System.out.println(moneyEarned[index]);
  }

  public void getSpendingRecord(int index) {
    System.out.println(moneySpent[index]);
  }
}
