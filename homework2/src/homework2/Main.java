package homework2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		7 February 2014
	 *  Purpose: 	Handles storing and retrieving gpas	
	 *  Uses:		 
	 *  
	 */

	static StudentRecWithInput [] studentRecs;
	static int MAX_RECORDS = 100;
	static int numRecords = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentRecs = new StudentRecWithInput[MAX_RECORDS];
		processStudentRecs();
		printStudentRecs();
		updateRecs();
	}
	public static void updateRecs(){
		/*
    	*  Purpose: Demonstrate update method
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		for (int x =0; x< numRecords; x++){
			studentRecs[x].update();			
		}
	}
	public static void printStudentRecs(){
		/*
    	*  Purpose: Print out contents of student records for debugging
    	*  Preconditions: none
    	*  Postconditions: none
    	*/

		for (int x =0; x< numRecords; x++){
			System.out.println(studentRecs[x]);			
		}
	}
	
	public static void processStudentRecs(){
		/*
    	*  Purpose: Read in student records and store in arrays
    	*  Preconditions: none
    	*  Postconditions: none
    	*/

		Scanner read;
		File logFile = new File("studentinfo.txt");

		try {
			System.out.println(logFile.getCanonicalPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			read = new Scanner (logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		while (read.hasNextLine())
		{
			String line = read.nextLine();
			String [] values = line.split(",");
			studentRecs[numRecords] = new StudentRecWithInput(values[0],values[1],values[2],
					                                 values[3],Double.parseDouble(values[4]),
					                                 Integer.parseInt(values[5]));
			numRecords++;
		}
		read.close();
	}

}
