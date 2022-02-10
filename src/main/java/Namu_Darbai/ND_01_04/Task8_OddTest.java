package Namu_Darbai.ND_01_04;


import java.util.Scanner;

/*
Write a boolean method called isOdd() in a class called OddTest,
 which takes an int as input and returns true if the it is odd.
 */
public class Task8_OddTest {

    public static boolean isOdd(int number) {
        return number % 2 != 0;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Iveskite skaiciu ir suzinokite ar jis yra nelyginis: ");
        System.out.println(Task8_OddTest.isOdd(scan.nextInt()));
    }
}
