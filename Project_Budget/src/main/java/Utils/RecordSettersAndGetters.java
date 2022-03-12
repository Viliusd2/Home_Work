package Utils;

import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentMethods;
import Modules.MoneyRecords.MoneyEarned;
import Modules.MoneyRecords.MoneySpent;
import Service.Menu.inicializer.ScannerInitializer;

import java.util.Random;

public class RecordSettersAndGetters {
  private static double sum;

  public static MoneyEarned earningsSetter() {
    // double suma, String date, boolean successfulTransfer, String papInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Gauta/Idedama suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneyEarned(sum, true, "kazkoks aprasas");
  }

  public static MoneySpent spendingsSetter() {
    // double sum, PaymentMethods paymentType, BankCards bankCardUsed, String extraInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Isleista suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneySpent(sum, PaymentMethods.Card, BankCards.Debit, "kazkoks aprasas");
  }
}
