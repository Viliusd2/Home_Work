package FileUtils;

import Model.Records.MoneyRecords;
import Service.Menu.MainMenu;

import javax.validation.constraints.NotNull;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class RecordReaderFromFile {
@NotNull
  public static ArrayList<MoneyRecords> reader() {
    ArrayList<MoneyRecords> records = new ArrayList<>();
    boolean cont = true;
    System.out.println("Write in file name: ");
    String fileName = new MainMenu().readInput() + ".csv";
    try {
      FileInputStream fileInput = new FileInputStream(fileName);
      ObjectInputStream objectInput = new ObjectInputStream(fileInput);

      while (cont) {
        Object record = null;
        try {
          record = objectInput.readObject();
        } catch (ClassNotFoundException | IOException e) {
          e.printStackTrace();
        }
        if(record != null)
         records.add((MoneyRecords) record);
        else
          cont = false;
      }
      objectInput.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
  }
}
