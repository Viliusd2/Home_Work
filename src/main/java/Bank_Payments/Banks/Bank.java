package Bank_Payments.Banks;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

// Bank class
public class Bank {
    private String bank;
    private LocalDate date;
    private String name = "Unknown";
    private String IBAN;
    private double amount;
    public static int eilesNr = 0;

    public Bank() {
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

    public static int getEilesNr() {
        return eilesNr;
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

}
