/*

import java.util.Scanner;
public class Quotient{
	public static void main(String[] arges){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		System.out.println(number1 + "/" + number2 + " is " + (number1 / number2));
	}
}
*/
import java.util.*;
public class Quotient{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		do{
			try{
				System.out.println("Enter an integer: ");
				int number = input.nextInt();
				System.out.println("The number entered is: " + number);
				continueInput = false;
			}
			catch(InputMismatchException ex) {
				System.out.println("Try again. (Incorrect input: an integer is required)");
				input.nextLine();
			}
		}while(continueInput);
	}
}