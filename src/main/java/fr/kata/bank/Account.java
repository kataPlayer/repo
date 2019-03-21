package fr.kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {

	private double balance;
	private List<Operation> statements;

	public Account() {
		balance = 0;
		statements = new ArrayList<Operation>();

	}

	public Account(double amount) throws NegativeNumberException {
		if (amount > 0) {
			this.balance = amount;
			statements = new ArrayList<Operation>();
			statements.add(Operation.createDepositOperation(amount));
		} else
			throw new NegativeNumberException("the amount must be positive");

	}

	public void deposit(double amount) throws NegativeNumberException {
		if (amount > 0) {
			this.balance += amount;
			statements.add(Operation.createDepositOperation(amount));
		} else
			throw new NegativeNumberException("the amount must be positive");

	}

	public void withdrawal(double amount) {
		if (amount > 0) {
			this.balance -= amount;
			statements.add(Operation.createWithdrawalOperation(amount));
		} else
			throw new NegativeNumberException("the amount must be positive");
	}

	public void printStatement() {
		for (Operation op : this.statements) {
			System.out.print(AccountUtils.createStatement(op.getDate(), op.getOperation().toString(), op.getAmount()));
			System.out.println();
		}

	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
