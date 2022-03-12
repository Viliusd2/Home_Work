package Service;

import Modules.Budget;
import Service.Menu.Console.RecordSettersAndGetters;
import Service.Menu.Console.ConsoleMenu;
import Service.Menu.MainMenu;

public class Application {
  private final ConsoleMenu mainMenu;
  private final Budget budget = new Budget();

  public Application() {
    this.mainMenu = new MainMenu();
  }

  public void run() {
    String selectedOption = mainMenu.printAndRead();
    // TODO: your implementation here
    choseMenuOption(selectedOption);
  }

  public void choseMenuOption(String text) {

    while (!"0".equals(text)) { // "[0]  - Exit\n";
      switch (text) {
        case "1":
          // "[1]  - Add Income listing\n"
          budget.addMoneyEarnedRecord(RecordSettersAndGetters.earningsSetter());
          break;
        case "2":
          // "[2]  - Add Spending listing\n"
          budget.addMoneySpentRecord(RecordSettersAndGetters.spendingsSetter());
          break;
        case "3":
          // "[3]  - Get Income listing\n" +
          budget.getEarningsRecord();
          break;
        case "4":
          // "[4]  - Get Spending listing\n" +
          budget.getSpendingRecord();
          break;
        default:
          System.out.println("Wrong input");
      }
      text = mainMenu.printAndRead();
    }
  }
}
