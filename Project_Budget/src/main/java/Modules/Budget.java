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

  public void getEarningsRecord() {
    for (int i = 0; i < earnedCounter; i++) {
      System.out.println(moneyEarned[i]);
    }
  }

  public void getSpendingRecord() {
    for (int i = 0; i < spentCounter; i++) {
      System.out.println(moneySpent[i]);
    }
  }
}
