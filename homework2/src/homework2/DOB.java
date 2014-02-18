package homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DOB {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		7 February 2014
	 *  Purpose: 	Handles Date of birth and age conversions	
	 *  Uses:		 
	 *  
	 */
	public String strDate;

	public DOB(String strDate) {
		this.strDate = strDate;
	}

	public int getAge() {
		/*
    	*  Purpose: Get the age of the student based on the current date
    	*  Preconditions: none
    	*  Postconditions: return age in years
    	*/
		Date date2 = null;
		try {
			date2 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
					.parse(strDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long age = new java.util.Date().getTime();
		age -= date2.getTime();
		age = (long) age / (60 * 60 * 24 * 365);
		age = (long) age / 1000;
		return (int) age;
	}
}
