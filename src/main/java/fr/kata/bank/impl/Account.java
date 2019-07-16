package fr.kata.bank.impl;

import java.util.ArrayList;
import java.util.List;

import fr.kata.bank.exception.NegativeNumberException;
import fr.kata.bank.AccountInterface;

public class Account implements AccountInterface {

	private  double balance;
	private final List<Operation> statements;


	public Account() {
		balance = 0;
		statements = new ArrayList<>();
	}

	public Account(double amount)  {
		this();
		this.balance = amount;
		statements.add(Operation.createDepositOperation(amount));
	}

	public void deposit(double amount) throws NegativeNumberException {
		if (amount > 0) {
			this.balance += amount;
			statements.add(Operation.createDepositOperation(amount));
		} else
			throw new NegativeNumberException("the amount must be positive");
	}

	public void withdrawal(double amount) throws NegativeNumberException{
		if (amount > 0) {
			this.balance -= amount;
			statements.add(Operation.createWithdrawalOperation(amount));
		} else
			throw new NegativeNumberException("the amount must be positive");
	}

	public List<Operation> getStatements() {
		return statements;
	}

	public double getBalance() {
		return balance;
	}

	
}
