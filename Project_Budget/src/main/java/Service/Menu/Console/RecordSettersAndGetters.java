package Service.Menu.Console;

import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentMethods;
import Modules.MoneyRecords.MoneyEarned;
import Modules.MoneyRecords.MoneySpent;
import Service.Menu.inicializer.ScannerInitializer;

public class RecordSettersAndGetters {

  public static MoneyEarned earningsSetter() {
    // double suma, String date, boolean successfulTransfer, String papInfo
    double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Gauta/Idedama suma: "));
    String date = ScannerInitializer.readParameterInput("Data: ");
    boolean success = true;
    String info = ScannerInitializer.readParameterInput("Papildoma info ");
    return new MoneyEarned(sum, date, success, info);
  }

  public static MoneySpent spendingsSetter() {
    // double sum, PaymentMethods paymentType, BankCards bankCardUsed, String extraInfo
    double suma = Double.parseDouble(ScannerInitializer.readParameterInput("Isleista suma: "));
    String info = ScannerInitializer.readParameterInput("Papildoma info ");
    return new MoneySpent(suma, PaymentMethods.Card, BankCards.Debit, info);
  }
}
