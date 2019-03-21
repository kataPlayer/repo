package fr.kata.bank;

import java.util.Date;

public class Operation {

	private  OperationType operation;
	private Date date;
	private double amount;
	
	public Operation(OperationType operation, Date date, double amount) {
		this.operation=operation;
		this.date=date;
		this.amount=amount;
	}
	
	
	public static Operation createDepositOperation(double amount){
		return new Operation(OperationType.Deposit, new Date(), amount);
	}
	
	public static Operation createWithdrawalOperation(double amount){
		return new Operation(OperationType.Withdrawal, new Date(), amount);
	}
	
	public OperationType getOperation() {
		return operation;
	}


	public void setOperation(OperationType operation) {
		this.operation = operation;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
}
