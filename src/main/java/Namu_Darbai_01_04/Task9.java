package Namu_Darbai_01_04;



public class Task9 {
/*
 Write a method called arrayToString(), which takes an int array and return a String in the form of {a1, a2, ..., an}.
 Take note that there is no comma after the last element.
 */

    public static void arrayToString(int[] numbers) {
        System.out.printf("Your array is: {%d, %d, %d, %d, %d}\n", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);
    }
    public static String arrayToString2(int[] numbers){
        String str = "{";
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                str = str + " ,";
            }
            String item = ""+numbers[i];
            str = str + item;
        }
        str = str + "}";
        return "Your array is: " + str;
    }

    public static void main(String[] args) {
        int[] arrayOfNumbers = {10, 55, 123, 68, 45};


        Task9.arrayToString(arrayOfNumbers);
        System.out.println(Task9.arrayToString2(arrayOfNumbers));
    }
}
