package Bank_Payments.Bank_Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LumiData extends Bank {

  public static final String[][] MOCK_DATA = {
    {"Debtor name", "Payment date", "IBAN", "Amount"},
    {"Karlson und Meier KG", "2022-01-14", "DE16333333330000002222", "10.12"},
    {"Karlson GmbH", "2022-01-04", "DE60123456781234567891", "431.00"},
    {"Karlson GmbH", "2022-01-24", "DE16444444440000033333", "36.99"},
    {"Karlson und Meier KG", "2022-01-15", "DE16333333330000002222", "140.50"},
  };

  public LumiData(String bank, String name, LocalDate date, String IBAN, double amount) {
    super(bank, date, name, IBAN, amount);
  }


  @Override
  public String toString() {
    return super.toString()
        + "LumiData: "
        + " Name = "
        + getName()
        + " Date = "
        + getDate()
        + " IBAN = "
        + getIBAN()
        + " Amount = "
        + getAmount()
        + "\n";
  }
}
