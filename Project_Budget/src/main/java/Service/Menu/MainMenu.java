package Service.Menu;

import Service.Menu.Console.ConsoleMenu;

public class MainMenu implements ConsoleMenu {
  private static final String mainMenu =
      "-----------------------------\n"
          + "Main menu for Budget Project\n"
          + "Chose option: \n"
          + "[1]  - Add Income listing\n"
          + "[2]  - Add Spending listing\n"
          + "[3]  - Get Income listing\n"
          + "[4]  - Get Spending listing\n"
          + "[5]  - Get Money Balance\n"
          + "[6] - Chose Entry To Delete\n"
          + "[0]  - Exit\n";

  @Override
  public void generateMenu() {
    System.out.println(mainMenu);
  }
}
