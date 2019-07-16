package fr.kata.bank;

import fr.kata.bank.exception.NegativeNumberException;

public interface AccountInterface {
	
	public void deposit(double amount) throws NegativeNumberException;
	
	public void withdrawal(double amount) throws NegativeNumberException;

	
}
