package Bank_Payments.Banks.BankForms;

import Bank_Payments.Banks.Bank;
import Bank_Payments.Banks.Bank_Data.LumiData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LumiForm extends Bank {

    public LumiForm() {

    }

    public LumiForm(String name, LocalDate date, String IBAN, double amount) {
        super("Lumi", date, name, IBAN, amount);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(
                " Name = %-25s Date = %-15s IBAN = %-30s Amount = %10.2f \n",
                getName(), getDate().toString(), getIBAN(), getAmount());
    }

    public static void getLumiData() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 1; i < LumiData.MOCK_DATA.length; i++) {
            System.out.println(  new LumiForm(
                            LumiData.MOCK_DATA[i][0],
                            LocalDate.parse(LumiData.MOCK_DATA[i][1], format),
                            LumiData.MOCK_DATA[i][2],
                            Double.parseDouble(LumiData.MOCK_DATA[i][3])));
        }

    }
}
