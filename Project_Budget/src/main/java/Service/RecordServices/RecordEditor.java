package Service.RecordServices;

import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentMethods;
import Model.ParameterClasses.Enums.PaymentRecordType;
import Model.ParameterClasses.PaymentCategory;
import Model.Records.MoneyEarnedRecord;
import Model.Records.MoneyRecords;
import Model.Records.MoneySpentRecords;
import Service.Menu.MainMenu;
import Service.Utils.EnumSetters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RecordEditor {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void editRecord(ArrayList<MoneyRecords> records, String recordId) {
        boolean continueLoop = true;
        int id = Integer.parseInt(recordId);

        while (continueLoop) {
            if (records.get(id).getPaymentRecordType().equals(PaymentRecordType.INCOME)) {
                records.set(id, moneyEarnedEdit(records.get(id)));
                continueLoop = false;
            } else if (records.get(id).getPaymentRecordType().equals(PaymentRecordType.SPENDING)){
                records.set(id, moneySpentEdit(records.get(id)));
                continueLoop = false;
            } else {
                System.out.println("Wrong id");
                id = Integer.parseInt(new MainMenu().readInput());
            }
        }
    }

    public void deleteRecord(ArrayList<MoneyRecords> records, String recordId) {
        int index = Integer.parseInt(recordId);
        records.remove(index);
    }

    private MoneyEarnedRecord moneyEarnedEdit(MoneyRecords record) {

        double sum = moneyAmountEdit(record);
        String info = infoEdit(record);

        System.out.println("Confirm record?");
        boolean confirm = editOption();
        return new MoneyEarnedRecord(sum, confirm, info);
    }

    private MoneySpentRecords moneySpentEdit(MoneyRecords record) {
        double moneyAmount = moneyAmountEdit(record);
        String info = infoEdit(record);

        MoneySpentRecords spentRecords = (MoneySpentRecords) record;

        PaymentMethods method = spentRecords.getPaymentMethod();
        PaymentCards card = spentRecords.getBankCardUsed();
        String category = spentRecords.getPaymentCategory();
        LocalDateTime date = spentRecords.getMoneySpentDate();
        boolean selection;

        System.out.println("Payment method: " + spentRecords.getPaymentMethod());
        selection = editOption();
        if (selection) {
            method = EnumSetters.setMethod();
            System.out.println("Payment Card: " + spentRecords.getPaymentMethod());
            selection = editOption();
            if (selection) {
                card = EnumSetters.setCard();
            }
        }

        System.out.println("Payment category: " + spentRecords.getPaymentCategory());
        selection = editOption();
        if (selection) {
            category = PaymentCategory.getCategories();
        }

        System.out.println("Payment date: " + spentRecords.getMoneySpentDate());
        selection = editOption();
        if (selection) {
            System.out.println("Input format yyyy-MM-dd HH:mm");
            date = LocalDateTime.parse(new MainMenu().readInput(), formatter);
        }
        return new MoneySpentRecords(moneyAmount, method, card, info, category, date);
    }

    private boolean editOption() {
        System.out.println("[1] - Edit\t[2] - Next");
        String select = new MainMenu().readInput();
        return select.equals("1");
    }
    private Double moneyAmountEdit(MoneyRecords record){
        System.out.println("Sum: " + record.getMoneyAmount());
        boolean selection = editOption();
        double moneyAmount = record.getMoneyAmount();
        if (selection) {
            moneyAmount = Double.parseDouble(new MainMenu().readInput());
        }
        return moneyAmount;
    }
    private String infoEdit(MoneyRecords record){
        System.out.println("Extra info: " + record.getCommentForRecord());
        boolean selection = editOption();
        String info = record.getCommentForRecord();
        if (selection) {
            info = new MainMenu().readInput();
        }
        return info;
    }
}
