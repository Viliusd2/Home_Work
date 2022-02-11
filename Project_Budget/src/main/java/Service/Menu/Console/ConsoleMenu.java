package Service.Menu.Console;

import Service.Menu.inicializer.Menu;
import static Service.Menu.inicializer.ScannerInitializer.getScanner;
public interface ConsoleMenu extends Menu {

    default String readInput() {
        System.out.println("Your input: ");

        return getScanner().nextLine();
    }

    default String printAndRead() {
        generateMenu();
        return readInput();
    }

}

