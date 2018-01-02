/*
Program by J.Levett
Simple program that converts user input(number 0 to 3,999,999) into a roman numeral and displays on the console.
 */

import java.util.Scanner;
public class App {

    public static void main(String...args){
      System.out.println("Enter an positive integer (3,999,999 max) please:");
      int number = getInput();
      if(number>3999999 || number < 0)
          System.out.println("Number must be between 0 and 3,999,999!");
      else
          System.out.println("In Roman Numerals this is: " + romanConversion(number));
    }

    public static String romanConversion(int number) {

        String romanString = "";

        if (number == 0) return "nulla";

        String singDig[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tenDig[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundDig[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        String thousDig[] = {"", "M", "MM", "MMM", "M(V)", "(V)", "(V)M", "(V)MM", "(V)MMM", "M(X)"};
        String tenthousDig[] = {"", "(X)", "(X)(X)", "(X)(X)(X)", "(X)(L)", "(L)", "(L)(X)", "(L)(X)(X)", "(L)(X)(X)(X)", "(X)(C)"};
        String hundthousDig[] = {"", "(C)", "(C)(C)", "(C)(C)(C)", "(C)(D)", "(D)", "(D)(C)", "(D)(C)(C)", "(D)(C)(C)(C)", "(C)(M)"};
        String millionDig[] = {"", "(M)", "(M)(M)", "(M)(M)(M)"};

        return millionDig[(number/1000000)%10]
                +hundthousDig[(number/100000)%10]
                +tenthousDig[(number/10000)%10]
                +thousDig[(number/1000)%10]
                +hundDig[(number/100)%10]
                +tenDig[(number/10)%10]
                +singDig[number%10];
}

    private static int getInput(){
        int number=0;

        try{
            Scanner scanner = new Scanner(System.in);
            String txtInput = scanner.nextLine();
            scanner.close();
            number = Integer.valueOf(txtInput);
        }catch(Exception e ) {
            System.out.println("Exception thrown: Something went wrong");
            System.exit(0);
        }
        return number;
    }
}