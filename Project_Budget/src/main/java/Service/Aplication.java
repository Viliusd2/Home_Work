package Service;

import Service.Menu.MainMenu;
import Modules.Budget;
import Modules.FinalParameters.PaymentMethods;
import Modules.FinalParameters.BankCards;
import Modules.MoneyRecords.MoneySpent;
import Modules.MoneyRecords.MoneyEarned;

public class Aplication {

  public void run() {
    new MainMenu().printMainMenu();
    Budget b1 = new Budget();
    b1.addMoneyEarnedRecord(new MoneyEarned(2000, "2001-05-06", true, "Atlyginimas"));
    b1.getEarningsRecord(0);
    b1.addMoneySpentRecord(new MoneySpent(200, PaymentMethods.Cash, BankCards.Debit, "Pirkinai"));
    b1.getSpendingRecord(0);
  }
}
