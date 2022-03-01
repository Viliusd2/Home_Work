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
    System.out.println("Chose which record to change by ID number");
    String recordID = new MainMenu().readInput();
    if (Integer.parseInt(recordID)>records.size()-1) {
      System.out.println("Wrong id number");
      editor(records);
    }
    System.out.println("[1] - Edit a record\n[2] - Delete a record");
    String selection = new MainMenu().readInput();
    switch (selection) {

      case "1":
        editRecord(records, recordID);
        break;
      case "2":
        deleteRecord(records, recordID);
        break;
      default:
        System.out.println("Wrong selection");
        editor(records);
    }
  }

  private void editRecord(ArrayList<MoneyRecords> records, String recordId) {
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


  private void deleteRecord(ArrayList<MoneyRecords> records, String recordId) {
    int index = Integer.parseInt(recordId);
    records.remove(index);
  }

  private MoneyEarnedRecord moneyEarnedEdit(MoneyRecords record) {

    double sum = sumEdit(record);
    String info = infoEdit(record);

    System.out.println("Confirm record?");
    boolean confirm = editOption();
    return new MoneyEarnedRecord(sum, confirm, info);
  }

  private MoneySpentRecords moneySpentEdit(MoneyRecords record) {
    double sum = sumEdit(record);
    String info = infoEdit(record);

    MoneySpentRecords spentRecords = (MoneySpentRecords) record;

    PaymentMethods method = spentRecords.getPaymentMethod();
    PaymentCards card = spentRecords.getBankCardUsed();
    String category = spentRecords.getCategory();
    LocalDateTime date = spentRecords.getDate();
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

    System.out.println("Payment category: " + spentRecords.getCategory());
    selection = editOption();
    if (selection) {
      category = PaymentCategory.getCategories();
    }

    System.out.println("Payment date: " + spentRecords.getDate());
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
  private Double sumEdit(MoneyRecords record){
    System.out.println("Sum: " + record.getSum());
    boolean selection = editOption();
    double sum = record.getSum();
    if (selection) {
      sum = Double.parseDouble(new MainMenu().readInput());
    }
    return sum;
  }
  private String infoEdit(MoneyRecords record){
    System.out.println("Extra info: " + record.getPapInfo());
    boolean selection = editOption();
    String info = record.getPapInfo();
    if (selection) {
      info = new MainMenu().readInput();
    }
    return info;
  }
}
