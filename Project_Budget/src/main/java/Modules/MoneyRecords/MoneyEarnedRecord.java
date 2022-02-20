package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentCategory;

import java.time.LocalDate;

public class MoneyEarnedRecord extends MoneyRecords{

  private LocalDate date;
  private final boolean sucsesfulTranfer;

  public MoneyEarnedRecord(double sum, boolean successfulTransfer, String papInfo) {
    super(sum, PaymentCategory.INCOME, papInfo);
    this.date = LocalDate.now();
    this.sucsesfulTranfer = successfulTransfer;
  }


  @Override
  public String toString() {
    return super.toString() + String.format(
            "\nDate = %s " + "\nTransfer success = %s\n",
             date, sucsesfulTranfer);
  }
}
