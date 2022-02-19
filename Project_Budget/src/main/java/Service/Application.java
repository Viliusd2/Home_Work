package Service;

import Modules.Budget;
import Utils.GetRecord;
import Utils.RecordSettersAndGetters;
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
         GetRecord.printRecords(budget.getMoneyEarned());
          break;
        case "4":
          // "[4]  - Get Spending listing\n" +
          GetRecord.printRecords(budget.getMoneySpent());
          break;
        case "5":
          // [5] - Get Money Balance
          budget.getMoneyBalance();
        case "6": //Chose entry to delete
          choseEntryFromList();
          break;
        default:
          System.out.println("Wrong input");
      }
      text = mainMenu.printAndRead();
    }
  }
  public void choseEntryFromList(){
    System.out.println("Chose which Entry \nTo delete from the list\n" +
            "[1] - From Income list\n" +
            "[2] - from Spending list\n");
    String text = mainMenu.readInput();
    switch (text) {
      case "1":        // "[1]  - Delete Income listing\n"
        GetRecord.printRecords(budget.getMoneyEarned());
        text = mainMenu.readInput();
        budget.getMoneyEarned().remove(Integer.parseInt(text)-1);
        break;
      case "2":// "[2]  - delete Spending listing\n"
        GetRecord.printRecords(budget.getMoneySpent());
        text = mainMenu.readInput();
        budget.getMoneySpent().remove(Integer.parseInt(text)-1);
        // "[2]  - delete Spending listing\n"
        break;
    }
  }
}
