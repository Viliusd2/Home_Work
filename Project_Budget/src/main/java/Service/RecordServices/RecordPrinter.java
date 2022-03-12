package Service.RecordServices;

import Model.Records.MoneyRecords;
import Model.ParameterClasses.Enums.PaymentRecordType;
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
        printSelection(list, PaymentRecordType.INCOME);
        break;

      case "3": //   "[3]  - Get Spendings"
        printSelection(list, PaymentRecordType.SPENDING);
        break;
      case "4":

    }
  }

  public static void printAll(ArrayList<MoneyRecords> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + "|" + list.get(i));
    }
  }

  private void printSelection(ArrayList<MoneyRecords> list, PaymentRecordType paymentRecordType) {
    for (int i = 0; i < list.size(); i++) {
      MoneyRecords moneyRecords = list.get(i);
      if (moneyRecords.getPaymentRecordType().equals(paymentRecordType)) {
        System.out.println(i + "|" + moneyRecords);
      }
    }
  }


}
