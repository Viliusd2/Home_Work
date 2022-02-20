package Utils;

import Modules.FinalParameters.BankCards;
import Modules.FinalParameters.PaymentMethods;
import Modules.MoneyRecords.MoneyEarnedRecord;
import Modules.MoneyRecords.MoneySpentRecords;

public class RecordSettersAndGetters {
  private static double sum;

  public static MoneyEarnedRecord earningsSetter() {
    // double suma, String date, boolean successfulTransfer, String papInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Gauta/Idedama suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneyEarnedRecord(sum, true, "kazkoks aprasas");
  }

  public static MoneySpentRecords spendingsSetter() {
    // double sum, PaymentMethods paymentType, BankCards bankCardUsed, String extraInfo
    //double sum = Double.parseDouble(ScannerInitializer.readParameterInput("Isleista suma: "));
    //String info = ScannerInitializer.readParameterInput("Papildoma info ");
    sum = (Math.random() * ((500 - 50) + 1)) + 50;
    return new MoneySpentRecords(sum, PaymentMethods.Card, BankCards.Debit, "kazkoks aprasas");
  }
}
