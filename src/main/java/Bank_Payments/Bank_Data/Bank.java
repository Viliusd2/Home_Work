package Bank_Payments.Bank_Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Bank class
public class Bank {
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
              LocalDate.parse(LumiData.MOCK_DATA[i][1], format),
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
              LocalDate.parse(SepData.MOCK_DATA[i][0], format),
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
    payments.sort(Comparator.comparing(Bank::getDate));
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
    return String.format("Eiles nr: %5d Bank %-8s", eilesNr, getBank());
  }

  public void printTableHeader() {
    String topTableBorder =
        String.format(
                    "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                    "\u2554", "\u2566", "\u2566", "\u2566", "\u2566", "\u2566", "\u2557")
                .replace(' ', '\u2550')
            + "\n";

    String parameterNameLine =
        String.format(
                "\u2551Eiles nr.:%2s Bank %8s Name   %25s Date   %15s IBAN   %30s Amount   %10s",
                "\u2551", "\u2551", "\u2551", "\u2551", "\u2551", "\u2551")
            + "\n";
    System.out.print(topTableBorder + parameterNameLine);
  }

  public void printParameter() {
    eilesNr++;
    String parameterLine =
        String.format(
                "\u2551 %-10d\u2551 %-12s\u2551 %-31s\u2551 %-21s\u2551 %-36s\u2551 %-18.2f\u2551",
                eilesNr, getBank(), getName(), getDate().toString(), getIBAN(), getAmount())
            + "\n";
    System.out.print(parameterLine);
  }

  public void printSeparatorLine() {
    String separatorLine =
        String.format(
                    "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                    "\u2560", "\u256C", "\u256C", "\u256C", "\u256C", "\u256C", "\u2563")
                .replace(' ', '\u2550')
            + "\n";
    System.out.print(separatorLine);
  }

  public void printTableBottom() {
    String botomTableBorder =
        String.format(
                    "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                    "\u255A", "\u2569", "\u2569", "\u2569", "\u2569", "\u2569", "\u255D")
                .replace(' ', '\u2550')
            + "\n";
    System.out.print(botomTableBorder);
  }
}
