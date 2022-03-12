package Service.RecordServices;

import Model.Records.MoneyRecords;
import Service.Menu.MainMenu;
import java.util.ArrayList;

public class RecordEditorMenu {
 private final RecordEditor editor = new RecordEditor();
  public void editor(ArrayList<MoneyRecords> records) {
    System.out.println("Chose which record to change by ID number");
    String recordID = new MainMenu().readInput();
    if (Integer.parseInt(recordID) > records.size() - 1) {
      System.out.println("Wrong id number");
      editor(records);
    }
    System.out.println("[1] - Edit a record\n[2] - Delete a record");
    String selection = new MainMenu().readInput();
    switch (selection) {
      case "1":
        editor.editRecord(records, recordID);
        break;
      case "2":
        editor.deleteRecord(records, recordID);
        break;
      default:
        System.out.println("Wrong selection");
        editor(records);
    }
  }
}
