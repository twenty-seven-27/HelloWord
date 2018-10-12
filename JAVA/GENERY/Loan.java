public class Loan{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Defaule constructor **/
	public Loan(){
		this(2.5, 1, 1000);
	}
	/** COnstruct a Loan with specified annual interest rate, 
	number of year, and loan amount.  **/
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}

	/** Return annualTnterest **/
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	/** Set a new annualTnterest **/
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears **/
	public double getNumberOfYears(){
		return numberOfYears;
	}
	/** Set a new numberOfYears **/
	public void getNumberOfYears(int numberOfYears){
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount **/
	public double getLoanAmount(){
		return loanAmount;
	}
	/** Set a new loanAmount **/
	public void setLoanAmount(double loanAmount){
		this.loanAmount = loanAmount;
	}

	/** Find monthly payment **/
	public double getMonthlyPayment(){
		double monthlyInterestRate = annualInterestRate/1200;
		double MonthlyPayment = loanAmount*monthlyInterestRate/(1-(1/Math.pow(1+monthlyInterestRate,numberOfYears*12)));
		return MonthlyPayment;
	}

	/** Find total payment**/
	public double getTotalPayment(){
		double totalPayment = getMonthlyPayment()*numberOfYears*12;
		return totalPayment;
	}

	/** Return Loan Date **/
	public java.util.Date getLoanDate(){
		return loanDate;
	}




























}