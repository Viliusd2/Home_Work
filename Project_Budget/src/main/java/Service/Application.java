package Service;

import Model.Budget;
import Service.Utils.RecordPrinter;
import Service.Utils.RecordGenerator;
import Service.Menu.Console.ConsoleMenu;
import Service.Menu.MainMenu;

public class Application {
  private final ConsoleMenu mainMenu;
  private final Budget budget = new Budget();
  private final RecordPrinter printer = new RecordPrinter();

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
          budget.addMoneyRecord(RecordGenerator.generateRecords());
          break;
        case "2":
          //Get listings
         printer.printRecords(budget.getMoneyRecords());
          break;
        case "3":
          // [5] - Get Money Balance
          budget.getMoneyBalance();
          break;
        case "4":
          //Chose entry to delete
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
        printer.printRecords(budget.getMoneyRecords());
        text = mainMenu.readInput();
        budget.getMoneyRecords().remove(Integer.parseInt(text)-1);
        break;
      case "2":// "[2]  - delete Spending listing\n"

        break;
    }
  }

}
