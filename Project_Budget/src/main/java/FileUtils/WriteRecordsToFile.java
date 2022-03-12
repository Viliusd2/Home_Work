package FileUtils;

import Model.Records.MoneyRecords;
import Service.Menu.MainMenu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteRecordsToFile {

    public static void writeRecords(ArrayList<MoneyRecords> list){
        System.out.println("Write in file name: ");
        String fileName = new MainMenu().readInput() + ".csv";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (MoneyRecords moneyRecords : list) {
                oos.writeObject(moneyRecords);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
