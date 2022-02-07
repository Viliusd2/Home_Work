package Bank_Payments.Bank_Data;

import java.time.LocalDate;


public class ShvedData extends Bank {

  public static final String[][] MOCK_DATA = {
    {"Execution date", "IBAN", "Paid Amount"},
    {"02.01.2022", "LT16333333330000002222", "10,12"},
    {"01.01.2022", "LT60123456781234567891", "431,00"},
    {"15.01.2022", "LT16333333330000002222", "140,50"},
    {"24.01.2022", "LT16444444440000033333", "36,99"},
  };

  public ShvedData(String bank, LocalDate executionDate, String IBAN, double amount) {
    super(bank, executionDate, IBAN, amount);
  }


  @Override
  public String toString() {
    return super.toString()
    + String.format(
            " Name = %-25s Date = %-15s IBAN = %-30s Amount = %10.2f \n",
            getName(), getDate().toString(), getIBAN(), getAmount());
  }
}
