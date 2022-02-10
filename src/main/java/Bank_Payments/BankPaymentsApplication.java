package Bank_Payments;

import Bank_Payments.Banks.AllBankRecords;
import Bank_Payments.Banks.Bank;
import Bank_Payments.Banks.BankForms.LumiForm;
import Bank_Payments.Banks.BankForms.SepForm;
import Bank_Payments.Banks.BankForms.ShvedForm;
import Bank_Payments.Menu.Console.ConsoleMenu;
import Bank_Payments.Menu.Console.MainMenu;
import Bank_Payments.Menu.Console.TablePrinter;


public class BankPaymentsApplication {

    private final ConsoleMenu mainMenu;

    public BankPaymentsApplication() {
        this.mainMenu = new MainMenu();
    }

    public void run() {
        String selectedOption = mainMenu.printAndRead();
        // TODO: your implementation here
        readDataTransfers(selectedOption);
    }

    public void readDataTransfers(String text) {

        while (!"0".equals(text)){
            switch (text) {
                case "1":
                    LumiForm.getLumiData();
                    break;
                case "2":
                    SepForm.getSepData();
                    break;
                case "3":
                    ShvedForm.getShvedData();
                    break;
                case "4":
                    TablePrinter.printTable(new AllBankRecords().getAllBankPaymentList());
                    break;
                default:
                    System.out.println("Wrong input");

            }
            Bank.eilesNr = 0;
            text = mainMenu.printAndRead();
            //run();
        }


    }

}
