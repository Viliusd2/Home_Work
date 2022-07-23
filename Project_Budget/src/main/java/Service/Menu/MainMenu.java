package Service.Menu;

import Service.Menu.Console.ConsoleMenu;

public class MainMenu implements ConsoleMenu {
  private static final String mainMenu =
      "-----------------------------\n"
          + "Main menu for Budget Project\n"
          + "Chose option: \n"
          + "[1]  - Add Records to listing\n"
          + "[2]  - Get All listing\n"
          + "[3]  - Get Money Balance\n"
          + "[4]  - Chose Entry Edit\n"
          + "[5]  - Write to a file\n"
          + "[6]  - Read from a file\n"
          + "[0]  - Exit\n";

  @Override
  public void generateMenu() {
    System.out.println(mainMenu);
  }
}
