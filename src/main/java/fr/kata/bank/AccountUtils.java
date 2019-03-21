package fr.kata.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountUtils {
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public static String createStatement(Date date, String operationType, Double amount) {
		return formatter.format(date)+" - "+operationType+" - "+amount;
	}

}
