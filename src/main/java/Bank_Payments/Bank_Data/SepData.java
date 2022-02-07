package Bank_Payments.Bank_Data;

import java.time.LocalDate;

public class SepData extends Bank {

  public static final String[][] MOCK_DATA = {
    {"Operation Date", "Payer Name", "IBAN", "Amount"},
    {"04.01.2022", "Simpson S", "SP60123456781234567891", "431.00"},
    {"24.01.2022", "Simpson S", "SP16444444440000033333", "36.99"},
    {"15.01.2022", "Luise S", "SP16333333330000002222", "140.50"},
    {"14.01.2022", "Luise S", "SP16333333330000002222", "10.12"},
  };

  public SepData(String bank, LocalDate date, String payerName, String IBAN, double amount) {
    super(bank, date, payerName, IBAN, amount);
  }

  @Override
  public String toString() {
    return super.toString()
        + String.format(
            " Name = %-25s Date = %-15s IBAN = %-30s Amount = %10.2f \n",
            getName(), getDate().toString(), getIBAN(), getAmount());
  }
}
