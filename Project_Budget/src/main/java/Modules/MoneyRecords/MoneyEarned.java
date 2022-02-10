package Modules.MoneyRecords;

import Modules.FinalParameters.PaymentCategory;

import java.time.LocalDate;

public class MoneyEarned {
  private double sum;
  private final PaymentCategory Category = PaymentCategory.INCOME;
  private LocalDate date;
  private boolean sucsesfulTranfer;
  private String papInfo;


  public MoneyEarned(double suma, String date, boolean successfulTransfer, String papInfo) {
    this.sum = suma;
    this.date = LocalDate.parse(date);
    this.sucsesfulTranfer = successfulTransfer;
    this.papInfo = papInfo;
  }


  public double getSum() {
    return sum;
  }

  public PaymentCategory getCategory() {
    return Category;
  }

  public LocalDate getDate() {
    return date;
  }

  public boolean isSucsesfulTranfer() {
    return sucsesfulTranfer;
  }

  public String getPapInfo() {
    return papInfo;
  }

  @Override
  public String toString() {
    return "Category = "
        + Category
        + "\nSum = "
        + sum
        + "\nDate = "
        + date
        + "\nTransfer success = "
        + sucsesfulTranfer
        + "\nExtra Info = '"
        + papInfo
        + "\n";
  }
}
