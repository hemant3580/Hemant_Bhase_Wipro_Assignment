// Assignment 3: Bank Account with Deposit/Withdraw Logic
package AssignmentDay5;

import java.util.*;

public class Assignment3 {
	public static void main(String[] args) {
		BankAccount acc = new BankAccount("12345678", "Hemant Bhase", 1000);
		acc.deposit(500);
		acc.withdraw(200);
		System.out.println(acc);
		System.out.println("Last Transaction: " + acc.getLastTransaction());
	}
}

class BankAccount {
	private String accountNumber;
	private String accountHolder;
	private double balance;
	private ArrayList<String> transactionHistory = new ArrayList<>();

	public BankAccount(String accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactionHistory.add("Deposited: " + amount);
			return true;
		}
		return false;
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
			transactionHistory.add("Withdrawn: " + amount);
			return true;
		}
		return false;
	}

	public double getBalance() {
		return balance;
	}

	public String getLastTransaction() {
		if (!transactionHistory.isEmpty()) {
			return transactionHistory.get(transactionHistory.size() - 1);
		}
		return "No transactions yet.";
	}

	public String toString() {
		return "Account Holder: " + accountHolder + ", Account Number: ****" + accountNumber.substring(accountNumber.length() - 4);
	}
}