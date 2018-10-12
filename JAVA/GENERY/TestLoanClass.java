import java.util.Scanner;
public class TestLoanClass{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter annul interest rate, for example, 8.25 :");
		double annulTnterestRate = input.nextDouble();

		System.out.print("Enter numbers of years as an integer:");
	    int  numberOfYears = input.nextInt();

		System.out.print("Enter loan amount, for example 1200000.95 :");
		double LOanAmout = input.nextDouble();

		Loan loan = 
		  new Loan(annulTnterestRate, numberOfYears, LOanAmout);

		System.out.printf("The loan was created on %s\n" + "The monthly payment is %.2f\n",
			loan.getLoanDate().toString(), loan.getMonthlyPayment(), loan.getTotalPayment());		
	} 

	
}