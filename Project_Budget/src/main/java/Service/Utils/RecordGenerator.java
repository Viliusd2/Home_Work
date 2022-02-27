package Service.Utils;

import Model.ParameterClasses.PaymentCategory;
import Model.Records.MoneyRecords;
import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentMethods;
import Model.Records.MoneyEarnedRecord;
import Model.Records.MoneySpentRecords;
import Service.Menu.MainMenu;

public class RecordGenerator {
  private static double sum;

  public static MoneyEarnedRecord earningsSetter() {
    // double suma, String date, boolean successfulTransfer, String papInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Gauta/Idedama suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneyEarnedRecord(sum, true, "kazkoks aprasas");
  }

  public static MoneySpentRecords spendingSetter() {
    // double sum, PaymentMethods paymentType, BankCards bankCardUsed, String extraInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Isleista suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneySpentRecords(sum, PaymentMethods.Card, PaymentCards.Debit, "kazkoks aprasas", PaymentCategory.getCategories());
  }

  public static MoneyRecords generateRecords() {
    boolean continueLoop = true;
    MoneyRecords record = null;

    while (continueLoop) {
      System.out.println("Chose what kind of record to add");
      System.out.println("[1] - Earnings\n[2] - Spending's");
      String selection = new MainMenu().readInput();
      if (selection.equals("1")) {
        record = earningsSetter();
        continueLoop = false;
      } else if (selection.equals("2")) {
        record = spendingSetter();
        continueLoop = false;
      } else {
        System.out.println("Wrong input");
      }
    }
    return  record;
  }
}
