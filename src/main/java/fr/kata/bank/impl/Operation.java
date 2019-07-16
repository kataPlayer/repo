package fr.kata.bank.impl;

import java.util.Date;
import java.util.List;

import fr.kata.bank.print.BankPrinterInterface;
import fr.kata.bank.print.impl.BankPrinter;
import fr.kata.bank.utils.OperationType;

public class Operation {

	private  final OperationType operationType;
	private final Date date;
	private final double amount;
	private static final BankPrinterInterface printer = new BankPrinter();

	public Operation(OperationType operationType, Date date, double amount) {
		this.operationType=operationType;
		this.date=date;
		this.amount=amount;
	}

	public static Operation createDepositOperation(double amount){
		return new Operation(OperationType.DEPOSIT, new Date(), amount);
	}

	public static Operation createWithdrawalOperation(double amount){
		return new Operation(OperationType.WITHDRAWAL, new Date(), amount);
	}

	public static void printStatements(List<Operation>statements) {
		for (Operation op : statements) {
			printer.printOperation(op);
		}
	}

	public OperationType getOperationType() {
		return operationType;
	}
	
	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

}
