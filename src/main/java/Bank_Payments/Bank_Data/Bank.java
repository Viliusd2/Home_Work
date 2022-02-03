package Bank_Payments.Bank_Data;

import Bank_Payments.Bank_Data.Interface.Methods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Bank class
public class Bank implements Methods {
  private String bank;
  private LocalDate date;
  private String name = "unknown";
  private String IBAN;
  private double amount;
  private List<Bank> payments = new ArrayList<>();

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
  }

  public void getLumiData() {
    for (int i = 1; i < LumiData.MOCK_DATA.length; i++) {
      payments.add(
          new LumiData("Lumi",
              LumiData.MOCK_DATA[i][0],
              getDateFromString(LumiData.MOCK_DATA[i][1]),
              LumiData.MOCK_DATA[i][2],
              Double.parseDouble(LumiData.MOCK_DATA[i][3])));
    }
  }

  public void getSepData() {
    for (int i = 1; i < SepData.MOCK_DATA.length; i++) {
      payments.add(
          new SepData("Sep",
              getDateFromString(SepData.MOCK_DATA[i][0]),
              SepData.MOCK_DATA[i][1],
              SepData.MOCK_DATA[i][2],
              Double.parseDouble(SepData.MOCK_DATA[i][3])));
    }
  }

  public void getShvedData() {
    for (int i = 1; i < ShvedData.MOCK_DATA.length; i++) {
      payments.add(
          new ShvedData("Shved",
              getDateFromString(ShvedData.MOCK_DATA[i][0]),
              ShvedData.MOCK_DATA[i][1],
              Double.parseDouble(ShvedData.MOCK_DATA[i][2].replace(',', '.'))));
    }
  }

  @Override
  public LocalDate getDateFromString(String string) {
    return null;
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
}
