package Bank_Payments.Banks.BankForms;

import Bank_Payments.Banks.Bank;
import Bank_Payments.Banks.Bank_Data.ShvedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShvedForm extends Bank {

    public ShvedForm() {
    }

    public ShvedForm(LocalDate executionDate, String IBAN, double amount) {
        super("Shved", executionDate, IBAN, amount);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(
                " Name = %-25s Date = %-15s IBAN = %-30s Amount = %10.2f \n",
                getName(), getDate().toString(), getIBAN(), getAmount());
    }

    public static void getShvedData() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 1; i < ShvedData.MOCK_DATA.length; i++) {
            System.out.println(new ShvedForm(
                    LocalDate.parse(ShvedData.MOCK_DATA[i][0], format),
                    ShvedData.MOCK_DATA[i][1],
                    Double.parseDouble(ShvedData.MOCK_DATA[i][2].replace(',', '.'))));
        }
    }
}
