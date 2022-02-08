package Bank_Payments;

import Bank_Payments.Bank_Data.Bank;
import Bank_Payments.Menu.Console.ConsoleMenu;
import Bank_Payments.Menu.Console.MainMenu;

public class BankPaymentsApplication {

  private final ConsoleMenu mainMenu;
  private final Bank bank = new Bank();

  public BankPaymentsApplication() {
    this.mainMenu = new MainMenu();
  }

  public void run() {
    String selectedOption = mainMenu.printAndRead();
    // TODO: your implementation here
    readDataTransfers(selectedOption);
  }

  public void readDataTransfers(String text) {
    label:
    for (int i = 0; i < bank.getPayments().size(); i++) {
      switch (text) {
        case "1":
          if (bank.getPayments().get(i).getBank().equalsIgnoreCase("lumi")) {
            System.out.println(bank.getPayments().get(i));
          }
          break;
        case "2":
          if (bank.getPayments().get(i).getBank().equalsIgnoreCase("sep")) {
            System.out.println(bank.getPayments().get(i));
          }
          break;
        case "3":
          if (bank.getPayments().get(i).getBank().equalsIgnoreCase("shved")) {
            System.out.println(bank.getPayments().get(i));
          }
          break;
        case "4":
          printTable();
          break label;
        case "0":
          return;
        default:
          System.out.println("Wrong input");
          break label;
      }
    }

    Bank.eilesNr = 0;
    run();
  }

  public void printTable() {

    bank.printTableHeader();
    bank.printSeparatorLine();
    for (int i = 0; i < bank.getPayments().size(); i++) {
      bank.getPayments().get(i).printParameter();
      if (bank.getPayments().indexOf(bank.getPayments().get(i)) == bank.getPayments().size() - 1) {
        break;
      } else {
        bank.printSeparatorLine();
      }
    }
    bank.printTableBottom();
  }
}