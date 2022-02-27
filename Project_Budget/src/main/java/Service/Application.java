package Service;

import FileUtils.RecordReaderFromFile;
import FileUtils.WriteRecordsToFile;
import Model.Budget;
import Service.Utils.RecordEditor;
import Service.Utils.RecordPrinter;
import Service.Utils.RecordGenerator;
import Service.Menu.Console.ConsoleMenu;
import Service.Menu.MainMenu;

public class Application {
  private final ConsoleMenu mainMenu;
  private final Budget budget = new Budget();
  private final RecordPrinter printer = new RecordPrinter();
  private final RecordEditor editor = new RecordEditor();

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
          // Chose entry to delete or edit
          RecordPrinter.printAll(budget.getMoneyRecords());
          editor.editor(budget.getMoneyRecords());
          break;
        case "5":
          // write to a file
          WriteRecordsToFile.writeRecords(budget.getMoneyRecords());
          break;
        case "6":
          //read from a file
          budget.setMoneyRecords(RecordReaderFromFile.reader());
        default:
          System.out.println("Wrong input");
      }
      text = mainMenu.printAndRead();
    }
  }


}
