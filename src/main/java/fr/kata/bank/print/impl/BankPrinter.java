package fr.kata.bank.print.impl;

import java.text.SimpleDateFormat;

import fr.kata.bank.impl.Operation;
import fr.kata.bank.print.BankPrinterInterface;

public class BankPrinter implements BankPrinterInterface{


	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public void printOperation(Operation operation) {
		System.out.println(formatter.format(operation.getDate())+" - "+operation.getOperationType()+" - "+operation.getAmount());
	}
}
