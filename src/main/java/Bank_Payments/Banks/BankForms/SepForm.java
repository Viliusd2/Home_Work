package Bank_Payments.Banks.BankForms;

import Bank_Payments.Banks.Bank;
import Bank_Payments.Banks.Bank_Data.SepData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SepForm extends Bank {

    public SepForm() {
    }

    public SepForm(LocalDate date, String payerName, String IBAN, double amount) {
        super("Sep", date, payerName, IBAN, amount);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(
                " Name = %-25s Date = %-15s IBAN = %-30s Amount = %10.2f \n",
                getName(), getDate().toString(), getIBAN(), getAmount());
    }

    public static void getSepData() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 1; i < SepData.MOCK_DATA.length; i++) {
            System.out.println(new SepForm(
                    LocalDate.parse(SepData.MOCK_DATA[i][0], format),
                    SepData.MOCK_DATA[i][1],
                    SepData.MOCK_DATA[i][2],
                    Double.parseDouble(SepData.MOCK_DATA[i][3])));
        }
    }
}
