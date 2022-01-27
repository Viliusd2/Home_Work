package Namu_Darbai.ND_01_04;

import java.util.Scanner;

/*
Write a Java program by using Scanner class  to prompt a user to
 input his/her name and then the output will be shown as an example below:Hello Dara!
 */
public class Task7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your name: ");
        String name = scan.nextLine();
        System.out.println("Hello " + name);
    }
}
