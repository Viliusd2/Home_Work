package Namu_Darbai_01_04;

import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    public static void lettersToNumpad(String sakinys){
        int[] numberArray = new int[sakinys.length()];
        for (int i = 0; i < sakinys.length(); i++) {
            char simbolis = sakinys.charAt(i);
            if (simbolis == 'A') {
                numberArray[i] = 2;
            } else if (simbolis == 'B') {
                numberArray[i] = 22;
            } else if (simbolis == 'C') {
                numberArray[i] = 222;
            }
            if (simbolis == 'D') {
                numberArray[i] = 3;
            } else if (simbolis == 'E') {
                numberArray[i] = 33;
            } else if (simbolis == 'F') {
                numberArray[i] = 333;
            }
            if (simbolis == 'G') {
                numberArray[i] = 4;
            } else if (simbolis == 'H') {
                numberArray[i] = 44;
            } else if (simbolis == 'I') {
                numberArray[i] = 444;
            }
            if (simbolis == 'J') {
                numberArray[i] = 5;
            } else if (simbolis == 'K') {
                numberArray[i] = 55;
            } else if (simbolis == 'L') {
                numberArray[i] = 555;
            }
            if (simbolis == 'M') {
                numberArray[i] = 6;
            } else if (simbolis == 'N') {
                numberArray[i] = 66;
            } else if (simbolis == 'O') {
                numberArray[i] = 666;
            }
            if (simbolis == 'P') {
                numberArray[i] = 7;
            } else if (simbolis == 'Q') {
                numberArray[i] = 77;
            } else if (simbolis == 'R') {
                numberArray[i] = 777;
            } else if (simbolis == 'S') {
                numberArray[i] = 7777;
            }
            if (simbolis == 'T') {
                numberArray[i] = 8;
            } else if (simbolis == 'U') {
                numberArray[i] = 88;
            } else if (simbolis == 'V') {
                numberArray[i] = 888;
            }
            if (simbolis == 'W') {
                numberArray[i] = 9;
            } else if (simbolis == 'X') {
                numberArray[i] = 99;
            } else if (simbolis == 'Y') {
                numberArray[i] = 999;
            } else if (simbolis == 'Z') {
                numberArray[i] = 9999;
            }
            if (simbolis == ' '){
                numberArray[i] = 0;
            }else if (simbolis == '.'){
                numberArray[i] = 1;
            }else if (simbolis == '?'){
                numberArray[i] = 11;
            }
        }
        System.out.println("Panaudoti klavisai rasant zinute: " + Arrays.toString(numberArray));
    }
    /*
    On your phone keypad, the alphabets are mapped to digits as follows: ABC(2), DEF(3), GHI(4), JKL(5), MNO(6), PQRS(7), TUV(8), WXYZ(9).
    Write a program called PhoneKeyPad, which prompts user for a String (case insensitive), and converts to a sequence of keypad digits.
    Use a nested-if (or switch-case) in this exercise.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Iveskite zinute: ");
        String sakinys = scan.nextLine().toUpperCase();
        Task10.lettersToNumpad(sakinys);

    }
}
