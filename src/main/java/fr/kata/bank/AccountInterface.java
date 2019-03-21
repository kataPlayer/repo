package fr.kata.bank;



public interface AccountInterface {
	
	public void deposit(double amount) throws Exception;
	
	public void withdrawal(double amount);

	public void printStatement();
}
