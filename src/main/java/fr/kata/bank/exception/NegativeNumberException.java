package fr.kata.bank.exception;

public class NegativeNumberException  extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NegativeNumberException(String message){
		this.message=message;
	}
}
