package Service.Menu.inicializer;

import java.util.Scanner;

public final class ScannerInitializer {

    private static Scanner scanner;

    private ScannerInitializer() {}

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }
    public static String readParameterInput(String parameter){
        System.out.println(parameter);
        return  getScanner().nextLine();
    }
}

