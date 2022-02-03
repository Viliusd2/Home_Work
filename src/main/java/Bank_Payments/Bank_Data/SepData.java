package Bank_Payments.Bank_Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
  public LocalDate getDateFromString(String string) {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    return LocalDate.parse(string, format);
  }

  @Override
  public String toString() {
    return "SepData: "
        + " name = "
        + getName()
        + " date = "
        + getDate()
        + " IBAN = "
        + getIBAN()
        + " amount = "
        + getAmount()
        + "\n";
  }
}
