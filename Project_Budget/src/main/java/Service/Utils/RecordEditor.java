package Service.Utils;

import Model.ParameterClasses.Enums.PaymentCards;
import Model.ParameterClasses.Enums.PaymentMethods;
import Model.ParameterClasses.Enums.PaymentRecordType;
import Model.ParameterClasses.PaymentCategory;
import Model.Records.MoneyEarnedRecord;
import Model.Records.MoneyRecords;
import Model.Records.MoneySpentRecords;
import Service.Menu.MainMenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RecordEditor {
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public void editor(ArrayList<MoneyRecords> records) {
    RecordPrinter.printAll(records);
    System.out.println("Chose which record to change by ID number");
    String recordID = new MainMenu().readInput();
    System.out.println("[1] - Edit a record\n[2] - Delete a record");
    String selection = new MainMenu().readInput();
    switch (selection) {
      case "1":
        editRecord(records, recordID);
        break;
      case "2":
        deleteRecord(records, recordID);
        break;
    }
  }

  private void editRecord(ArrayList<MoneyRecords> records, String recordId) {
    System.out.println();
    boolean continueLoop = true;
    int id = Integer.parseInt(recordId);

      while (continueLoop) {
          if (records.get(id).getPaymentRecordType().equals(PaymentRecordType.INCOME)) {
            records.set(id, moneyEarnedEdit((MoneyEarnedRecord) records.get(id)));
            continueLoop = false;
          } else if (records.get(id).getPaymentRecordType().equals(PaymentRecordType.SPENDING)){
            records.set(id, moneySpentEdit((MoneySpentRecords) records.get(id)));
            continueLoop = false;
          } else {
          System.out.println("Wrong id");
          id = Integer.parseInt(new MainMenu().readInput());
        }
      }
    }


  private void deleteRecord(ArrayList<MoneyRecords> records, String recordId) {
    int index = Integer.parseInt(recordId);
    records.remove(index);
  }

  private MoneyEarnedRecord moneyEarnedEdit(MoneyEarnedRecord record) {

    double sum = record.getSum();
    String info = record.getPapInfo();

    System.out.println("Income Sum: " + record.getSum());
    boolean selection = editOption();
    if (selection) {
      sum = Double.parseDouble(new MainMenu().readInput());
    }

    System.out.println("Extra info: " + record.getPapInfo());
    selection = editOption();
    if (selection) {
      info = new MainMenu().readInput();
    }
    System.out.println("Confirm record?");
    boolean confirm = editOption();
    return new MoneyEarnedRecord(sum, confirm, info);
  }

  private MoneySpentRecords moneySpentEdit(MoneySpentRecords record) {

    double sum = record.getSum();
    String info = record.getPapInfo();
    PaymentMethods method = record.getPaymentMethod();
    PaymentCards card = record.getBankCardUsed();
    String category = record.getCategory();
    LocalDateTime date = record.getDate();

    System.out.println("Income Sum: " + record.getSum());
    boolean selection = editOption();
    if (selection) {
      sum = Double.parseDouble(new MainMenu().readInput());
    }
    System.out.println("Extra info: " + record.getPapInfo());
    selection = editOption();
    if (selection) {
      info = new MainMenu().readInput();
    }

    System.out.println("Payment method: " + record.getPaymentMethod());
    selection = editOption();
    if (selection) {
      method = EnumSetters.setMethod();
      System.out.println("Payment Card: " + record.getPaymentMethod());
      selection = editOption();
      if (selection) {
        card = EnumSetters.setCard();
      }
    }

    System.out.println("Payment category: " + record.getCategory());
    selection = editOption();
    if (selection) {
      category = PaymentCategory.getCategories();
    }

    System.out.println("Payment date: " + record.getDate());
    selection = editOption();
    if (selection) {
      System.out.println("Input format yyyy-MM-dd HH:mm");
      date = LocalDateTime.parse(new MainMenu().readInput(), formatter);
    }
    return new MoneySpentRecords(sum, method, card, info, category, date);
  }

  private boolean editOption() {
    System.out.println("[1] - Edit\t[2] - Next");
    String select = new MainMenu().readInput();
    return select.equals("1");
  }
}
