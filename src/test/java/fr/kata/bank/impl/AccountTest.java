package fr.kata.bank.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.kata.bank.exception.NegativeNumberException;

public class AccountTest {

	private Account myAccount;

	

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

	

}
