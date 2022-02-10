package Bank_Payments.Menu.Console;

import Bank_Payments.Banks.Bank;

import java.util.List;

import static Bank_Payments.Banks.Bank.eilesNr;
import static Bank_Payments.Banks.Bank.getEilesNr;

public class TablePrinter {
    public static void printTable(List<Bank> allBankPaymentList) {
        printTableHeader();
        printParameter(allBankPaymentList);
        printTableBottom();
    }

    private static void printTableHeader() {
        String topTableBorder =
                String.format(
                                "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                                "\u2554", "\u2566", "\u2566", "\u2566", "\u2566", "\u2566", "\u2557")
                        .replace(' ', '\u2550')
                        + "\n";

        String parameterNameLine =
                String.format(
                        "\u2551Eiles nr.:%2s Bank %8s Name   %25s Date   %15s IBAN   %30s Amount   %10s",
                        "\u2551", "\u2551", "\u2551", "\u2551", "\u2551", "\u2551")
                        + "\n";
        System.out.print(topTableBorder + parameterNameLine);
    }

    private static void printParameter(List<Bank> allBankPaymentList) {
        for (Bank bank : allBankPaymentList) {
            printSeparatorLine();
            eilesNr++;
            String parameterLine =
                    String.format(
                            "\u2551 %-10d\u2551 %-12s\u2551 %-31s\u2551 %-21s\u2551 %-36s\u2551 %-18.2f\u2551",
                            getEilesNr(), bank.getBank(), bank.getName(), bank.getDate().toString(), bank.getIBAN(), bank.getAmount())
                            + "\n";
            System.out.print(parameterLine);
        }
    }

    private static void printSeparatorLine() {
        String separatorLine =
                String.format(
                                "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                                "\u2560", "\u256C", "\u256C", "\u256C", "\u256C", "\u256C", "\u2563")
                        .replace(' ', '\u2550')
                        + "\n";
        System.out.print(separatorLine);
    }

    private static void printTableBottom() {
        String botomTableBorder =
                String.format(
                                "%-12s%-14s%-33s%-23s%-38s%-20s%s",
                                "\u255A", "\u2569", "\u2569", "\u2569", "\u2569", "\u2569", "\u255D")
                        .replace(' ', '\u2550')
                        + "\n";
        System.out.print(botomTableBorder);
    }
}
