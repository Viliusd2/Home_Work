package Service.RecordServices;

import Model.ParameterClasses.PaymentCategory;
import Model.Records.MoneyRecords;
import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentMethods;
import Model.Records.MoneyEarnedRecord;
import Model.Records.MoneySpentRecords;
import Service.Menu.MainMenu;
import Service.Utils.EnumSetters;

public class RecordGenerator {
  private static double sum;

  public static MoneyEarnedRecord earningsSetter() {
    return new MoneyEarnedRecord((Math.random() * ((500 - 50) + 1)) + 50, true, "kazkoks aprasas");
  }

  public static MoneySpentRecords spendingSetter() {
    return new MoneySpentRecords((Math.random() * ((500 - 50) + 1)) + 50, EnumSetters.setMethod(), EnumSetters.setCard(), "kazkoks aprasas", PaymentCategory.getCategories());
  }

  public static MoneyRecords generateRecords() {
    boolean continueLoop = true;
    MoneyRecords record = null;

    while (continueLoop) {
      System.out.println("Chose what kind of record to add");
      System.out.println("[1] - Earnings\n[2] - Spending's");
      String selection = new MainMenu().readInput();

      switch (selection){
        case  "1":
          record = earningsSetter();
          continueLoop = false;
          break;
        case "2":
          record = spendingSetter();
          continueLoop = false;
          break;
        default:
          System.out.println("Wrong input");
      }
    }
    return  record;
  }
}
