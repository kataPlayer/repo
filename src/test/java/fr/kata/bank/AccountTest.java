package fr.kata.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private Account myAccount;
	private static OutputStream outContent;

	@BeforeEach
	void createAccount() {
		myAccount = new Account();
	}

	@BeforeAll
	static void prepareSystemOutAccount() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void testDeposit() throws NegativeNumberException {
		myAccount.deposit(100);
		myAccount.deposit(20.52);
		assertEquals(120.52, myAccount.getBalance());
	}

	@Test
	void testNegativeDeposit() throws NegativeNumberException {
		Assertions.assertThrows(NegativeNumberException.class, () -> {
			myAccount.deposit(-58);
		});
	}

	@Test
	void testWithdrawal() throws NegativeNumberException {
		myAccount.deposit(100);
		myAccount.withdrawal(30.25);
		assertEquals(69.75, myAccount.getBalance());
	}

	@Test
	void testNegativeWithdrawal() throws NegativeNumberException {
		Assertions.assertThrows(NegativeNumberException.class, () -> {
			myAccount.withdrawal(-23.21);
		});
	}

	@Test
	void testNegativeBalance() throws NegativeNumberException {
		myAccount.deposit(100);
		myAccount.withdrawal(505.50);
		assertEquals(-405.50, myAccount.getBalance());
	}

	@Test
	void testPrint() throws NegativeNumberException {
		myAccount.deposit(100);
		String expectedOutput = AccountUtils.createStatement(new Date(), OperationType.Deposit.toString(),
				Double.valueOf(100));
		expectedOutput += "\r\n";
		myAccount.printStatement();
		assertEquals(expectedOutput, outContent.toString());

	}

}
