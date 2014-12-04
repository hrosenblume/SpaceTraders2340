package application;

public class BankAccount {
	private String name;
	private double balance;
	private boolean loaned;
	private double loanAmount = 0;
	private final static double interest = 6;
	
	public BankAccount(String name, double balance, boolean loaned) {
		name = this.name;
		balance = this.balance;
		loaned = false;
	}
	
	public void deposit(double amt) {
		if (amt > 0) {
			balance += amt;
		}
	}
	
	public void withdraw(double amt) {
		if (amt > balance) {
			return;
		} else {
			balance -= amt;
		}
	}
	
	public void loan(double amt) {
		if(!loaned) {
			if (amt > 0 && amt <= balance/2) {
				balance += amt;
				loaned = true;
			}
			loanAmount = amt;
		}
	}
	
	private double chargeInterest(double amt) {
		return amt*interest;
	}
	
	public void payloan() {
		balance -= loanAmount + chargeInterest(loanAmount);
		loaned = false;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean hasLoan() {
		return loaned;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
}
