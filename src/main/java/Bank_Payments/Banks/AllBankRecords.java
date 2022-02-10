package Bank_Payments.Banks;


import Bank_Payments.Banks.BankForms.LumiForm;
import Bank_Payments.Banks.BankForms.SepForm;
import Bank_Payments.Banks.BankForms.ShvedForm;
import Bank_Payments.Banks.Bank_Data.LumiData;
import Bank_Payments.Banks.Bank_Data.SepData;
import Bank_Payments.Banks.Bank_Data.ShvedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AllBankRecords {
    private final List<Bank> allBankPaymentList = new ArrayList<>();

    public AllBankRecords() {
    addAllBankPayments();
    }

    public void addAllBankPayments() {
        addAllLumiPayments();
        addShvedPayments();
        addSepPayments();
        Bank.sort(allBankPaymentList);
    }

    public List<Bank> getAllBankPaymentList() {
        return allBankPaymentList;
    }

    public void addAllLumiPayments(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 1; i < LumiData.MOCK_DATA.length; i++) {
           allBankPaymentList.add(new LumiForm(
                    LumiData.MOCK_DATA[i][0],
                    LocalDate.parse(LumiData.MOCK_DATA[i][1], format),
                    LumiData.MOCK_DATA[i][2],
                    Double.parseDouble(LumiData.MOCK_DATA[i][3])));
        }
    }
    public void addShvedPayments() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 1; i < ShvedData.MOCK_DATA.length; i++) {
            allBankPaymentList.add(new ShvedForm(
                    LocalDate.parse(ShvedData.MOCK_DATA[i][0], format),
                    ShvedData.MOCK_DATA[i][1],
                    Double.parseDouble(ShvedData.MOCK_DATA[i][2].replace(',', '.'))));
        }
    }
    public void addSepPayments() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (int i = 1; i < SepData.MOCK_DATA.length; i++) {
            allBankPaymentList.add(new SepForm(
                    LocalDate.parse(SepData.MOCK_DATA[i][0], format),
                    SepData.MOCK_DATA[i][1],
                    SepData.MOCK_DATA[i][2],
                    Double.parseDouble(SepData.MOCK_DATA[i][3])));
        }
    }

}
