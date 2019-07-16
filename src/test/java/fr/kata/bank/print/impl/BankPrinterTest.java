package fr.kata.bank.print.impl;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.kata.bank.impl.Operation;
import fr.kata.bank.impl.OperationType;
import fr.kata.bank.print.BankPrinterInterface;

public class BankPrinterTest {
	
	
	private static  BankPrinterInterface bankPrinter;
	private static OutputStream outContent;
	
	@BeforeAll
	static void createAccount() {
		bankPrinter = new BankPrinter();
	}
	
	@BeforeEach
	 void openNewOutputStrem() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	void testPrintOperation() {
		 LocalDate date = LocalDate.of(2019, Month.DECEMBER, 12);
		Operation operation = new Operation(OperationType.DEPOSIT, Date.valueOf(date), 25.36);
		bankPrinter.printOperation(operation);
		String expectedOutput = "12-12-2019 - "+OperationType.DEPOSIT+" - "+Double.valueOf(25.36);
		expectedOutput += "\r\n";
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testFalsePrintOperation() {
		 LocalDate date = LocalDate.of(2007, Month.JULY, 24);
		Operation operation = new Operation(OperationType.DEPOSIT, Date.valueOf(date), 25.36);
		bankPrinter.printOperation(operation);
		String expectedOutput = "01-02-2020 - "+OperationType.DEPOSIT+" - "+Double.valueOf(25.36);
		expectedOutput += "\r\n";
		assertNotEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testNullPrintOperation() {
		 Operation operation = null;
		assertThrows(NullPointerException.class, ()->bankPrinter.printOperation(operation));
	}

}
