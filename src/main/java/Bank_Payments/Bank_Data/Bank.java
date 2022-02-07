package Bank_Payments.Bank_Data;

import Bank_Payments.Bank_Data.Interface.Methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Bank class
public class Bank implements Methods {
  private String bank;
  private LocalDate date;
  private String name = "Unknown";
  private String IBAN;
  private double amount;
  private List<Bank> payments = new ArrayList<>();
  public static int eilesNr = 0;

  public Bank() {
    addEntries();
  }

  public Bank(String bank, LocalDate date, String IBAN, double amount) {
    this.bank = bank;
    this.date = date;
    this.IBAN = IBAN;
    this.amount = amount;
  }

  public Bank(String bank, LocalDate date, String name, String IBAN, double amount) {
    this.bank = bank;
    this.date = date;
    this.name = name;
    this.IBAN = IBAN;
    this.amount = amount;
  }

  public String getBank() {
    return bank;
  }

  public List<Bank> getPayments() {
    return payments;
  }

  public void addEntries() {
    getLumiData();
    getSepData();
    getShvedData();
    sort(payments);
  }

  public void getLumiData() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    for (int i = 1; i < LumiData.MOCK_DATA.length; i++) {
      payments.add(
          new LumiData(
              "Lumi",
              LumiData.MOCK_DATA[i][0],
              LocalDate.parse(LumiData.MOCK_DATA[i][1],format),
              LumiData.MOCK_DATA[i][2],
              Double.parseDouble(LumiData.MOCK_DATA[i][3])));
    }
  }

  public void getSepData() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    for (int i = 1; i < SepData.MOCK_DATA.length; i++) {
      payments.add(
          new SepData(
              "Sep",
                  LocalDate.parse(SepData.MOCK_DATA[i][0],format),
              SepData.MOCK_DATA[i][1],
              SepData.MOCK_DATA[i][2],
              Double.parseDouble(SepData.MOCK_DATA[i][3])));
    }
  }

  public void getShvedData() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    for (int i = 1; i < ShvedData.MOCK_DATA.length; i++) {
      payments.add(
          new ShvedData(
              "Shved",
                  LocalDate.parse(ShvedData.MOCK_DATA[i][0], format),
              ShvedData.MOCK_DATA[i][1],
              Double.parseDouble(ShvedData.MOCK_DATA[i][2].replace(',', '.'))));
    }
  }

  public static void sort(List<Bank> payments) {
    Collections.sort(payments, new Comparator<Bank>() {
      @Override
      public int compare(Bank o1, Bank o2) {
        return o1.getDate().compareTo(o2.getDate());
      }});
  }

  public String getName() {
    return name;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getIBAN() {
    return IBAN;
  }

  public double getAmount() {
    return amount;
  }


  @Override
  public String toString() {
    eilesNr++;
    return "Eiles nr.: " + eilesNr + " Bank ";
  }
}
