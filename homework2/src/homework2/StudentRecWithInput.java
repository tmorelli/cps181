package homework2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentRecWithInput extends StudentRec {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		7 February 2014
	 *  Purpose: 	Handles storing and retrieving gpas	
	 *  Uses:		 
	 *  
	 */

	
	
	
	public StudentRecWithInput(String lastName, String firstName, String age, String major, 
			double gpa, int creditsEarned){
		super(lastName, firstName, age, major, gpa, creditsEarned);
	}
	
	public void update(){
		/*
    	*  Purpose: Read in this semester's data
    	* 
    	*  Preconditions: none
    	*  Postconditions: none
    	*/

		
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter GPA");
	        double newgpa = 0.0;
	        int newCredits = 0;
	        try {
	            newgpa = Double.parseDouble(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.print("Enter Number of Credits:");
	        try{
	            newCredits = Integer.parseInt(br.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        double oldTotal = gpa*creditsEarned;
	        double newTotal = oldTotal + newCredits*newgpa;
	        int newTotalCredits = creditsEarned + newCredits;
	        double nextGPA = newTotal/newTotalCredits;
	        
	        System.out.println("OldTotal Credits: "+creditsEarned);
	        System.out.println("NewTotal Credits: "+newTotalCredits);
	        
	        System.out.println("OldGPA : "+gpa);
	        System.out.println("NewGPA : "+nextGPA);
	        logChange(creditsEarned, newTotalCredits,gpa, nextGPA);
	}
	public void logChange(int oldCredits,int newCredits, double oldGPA, double newGPA){
		/*
    	*  Purpose: log changes made in update method
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		BufferedWriter writer = null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateString =dateFormat.format(date); 
		
		try {
			File logFile = new File("changes.txt");

			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile,true));
			writer.write("Modifying: " + super.getFirstName() + " " + 
					super.getLastName()+ " "+ dateString+"\n");
			
			writer.write("Old: " + oldCredits + "," + oldGPA +"\n"); 
			writer.write("New: " + newCredits + "," + newGPA +"\n\n"); 
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
				return ;
			}
		}
	}
}
