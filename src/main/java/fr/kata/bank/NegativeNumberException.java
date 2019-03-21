package fr.kata.bank;

public class NegativeNumberException  extends RuntimeException {

	
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
