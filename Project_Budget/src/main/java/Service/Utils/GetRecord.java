package Service.Utils;

import java.util.ArrayList;

public class GetRecord {
    public static <MoneyRecords> void printRecords(ArrayList<MoneyRecords> list){
        for (MoneyRecords e : list) {
            System.out.println(e);
        }
    }
}
