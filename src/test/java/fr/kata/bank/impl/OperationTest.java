package fr.kata.bank.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.kata.bank.exception.NegativeNumberException;

public class OperationTest {
	
	private Account myAccount;
	private static OutputStream outContent = new ByteArrayOutputStream();
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	@BeforeAll
	static void prepareSystemOutAccount() {
		System.setOut(new PrintStream(outContent));
	}
	
	@BeforeEach
	void createAccount() {
		myAccount = new Account();
	}
	
	@Test
	void testPrintStatements() throws NegativeNumberException {
		myAccount.deposit(100);
		String expectedOutput = formatter.format(new Date())+" - "+OperationType.DEPOSIT+" - "+Double.valueOf(100);
		expectedOutput += "\r\n";
		Operation.printStatements(myAccount.getStatements());
		assertEquals(expectedOutput, outContent.toString());
	}

}
