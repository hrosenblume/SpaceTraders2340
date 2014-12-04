package application;

public class BankAccount {
	private String name;
	private int balance;
	private boolean loaned;
	private int loanAmount = 0;
	private final static int interest = 6;
	
	public BankAccount(String name, double balance, boolean loaned) {
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
			if (amt > 0 && amt <= balance/2) {
				balance += amt;
				loaned = true;
			}
			loanAmount = amt;
		}
	}
	
	private int chargeInterest(int amt) {
		return amt*interest;
	}
	
	public void payloan() {
		balance -= loanAmount + chargeInterest(loanAmount);
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
