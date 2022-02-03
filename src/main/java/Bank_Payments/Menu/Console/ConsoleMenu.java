package Bank_Payments.Menu.Console;

import Bank_Payments.Menu.Menu;


import static Bank_Payments.Menu.Console.initialiser.ScannerInitializer.getScanner;

/**
 * Every console menu's should use this interface
 *
 * @author pavel.vrublevskij
 */
public interface ConsoleMenu extends Menu {

  /**
   * Method waits for user input and return @{@link String}
   *
   * @return String as input
   */
  default String readInput() {
    System.out.println("Your input: ");

    return getScanner().nextLine();
  }

  default String printAndRead() {
    generateMenu();
    return readInput();
  }
}
