package Service.Utils;

import Model.MoneyRecords.MoneyRecords;
import Model.ParameterClasses.RecordType;
import Service.Menu.Console.ConsoleMenu;
import Service.Menu.MainMenu;

import java.util.ArrayList;

public class RecordPrinter {
  private final ConsoleMenu meniu;

  public RecordPrinter() {
    this.meniu = new MainMenu();
  }

  public void printRecords(ArrayList<MoneyRecords> list) {

    System.out.print(
        "\nChose which listing to see:\n"
            + "[1]  - Get All listing\n"
            + "[2]  - Get Earnings listing\n"
            + "[3]  - Get Spendings listing\n");

    String selectOption = meniu.readInput();
    switch (selectOption) {
      case "1": // "[1]  - Get All listing\n"
        printAll(list);
        break;
      case "2": //  "[2]  - Get Earnings listing\n"
        printSelection(list,RecordType.INCOME);
        break;

      case "3": //   "[3]  - Get Spendings"
        printSelection(list,RecordType.SPENDING);
        break;
      case "4":
        
    }
  }

  private void printAll(ArrayList<MoneyRecords> list) {
     System.out.println(list);
  }

  private void printSelection(ArrayList<MoneyRecords> list,RecordType recordType) {
    for (MoneyRecords moneyRecords : list) {
      if (moneyRecords.getRecordType().equals(recordType)) {
        System.out.println(moneyRecords);
      }
    }
  }


}
