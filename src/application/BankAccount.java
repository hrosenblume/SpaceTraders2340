package application;

public class BankAccount {
	private String name;
	private int balance;
	private boolean loaned;
	private int loanAmount = 0;
	private final static int interest = 6;
	
	public BankAccount(String name, int balance, boolean loaned) {
		name = this.name;
		balance = this.balance;
		loaned = false;
	}
	
	public void deposit(int amt) {
		if (amt > 0) {
			balance += amt;
		}
	}
	
	public void withdraw(int amt) {
		if (amt > balance) {
			return;
		} else {
			balance -= amt;
		}
	}
	
	public void loan(int amt) {
		if(!loaned) {
			balance += amt;
			loaned = true;
			loanAmount = amt;
		}
	}
	
	public int chargeInterest(int amt) {
		double result = amt*((double) interest / 100);
		return (int) result;
	}
	
	public void payloan() {
		balance -= loanAmount + chargeInterest(loanAmount);
		loanAmount = 0;
		loaned = false;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean hasLoan() {
		return loaned;
	}
	
	public int getLoanAmount() {
		return loanAmount;
	}
}
