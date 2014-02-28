package HWK3;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Grades {

	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		20 February 2014
	 *  Purpose: 	Handles Grade related data	
	 *  Uses:		 
	 *  
	 */
	static int numStudents = 5;
	static int numGrades = 5;
	int [][] grades = new int[numStudents][numGrades];
	NameGrades[] nameGrades = new NameGrades[numStudents];


	public void processFile(String fileName){
		/*
    	*  Purpose: Read in the file and populate members
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		Scanner read;
		File logFile = new File(fileName);

		try {
			read = new Scanner (logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		int totalStudents = 0;
		while (read.hasNextLine())
		{
			String line = read.nextLine();
			String [] values = line.split(",");
			for (int x =0; x< numGrades; x++){
				grades[totalStudents][x] = Integer.parseInt(values[x]);
			}
			totalStudents++;
		}
		read.close();
	}

	public void processFileWithNames(String fileName){
		/*
    	*  Purpose: Read in the file (with names as first column) and populate members
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		Scanner read;
		File logFile = new File(fileName);

		try {
			read = new Scanner (logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		int totalStudents = 0;
		while (read.hasNextLine())
		{
			String line = read.nextLine();
			String [] values = line.split(",");
			int [] g = new int[numGrades];
			String name = values[0];
			for (int x =1; x< numGrades+1; x++){
				g[x-1] = Integer.parseInt(values[x]);
			}
			nameGrades[totalStudents] = new NameGrades();
			nameGrades[totalStudents].setStudentName(name);
			nameGrades[totalStudents].setGrades(g);
			totalStudents++;
		}
		read.close();
	}


	public void printGrades(){
		/*
    	*  Purpose: Print out grades
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				System.out.print(" "+ grades[x][y]);
			}
			System.out.println("");
		}
	}

	public void printGradesWithNames(){
		/*
    	*  Purpose: Print out grades and names
    	*  Preconditions: none
    	*  Postconditions: none
    	*/
		for (int x =0; x< numStudents;x++ ){
			System.out.print(nameGrades[x].getStudentName());
			for (int y = 0; y < numGrades; y++){
				System.out.print(" " +nameGrades[x].getGrades()[y]);
			}
			System.out.println("");
		}
	}
	
	public void printLowestScore(){
		 
	System.out.println(getLowest(grades));
	
	}
	
	public void printHighestScore(){
		
		System.out.println(getHighest(grades));
	}
	
	public void printAverageScore(){
		
		System.out.println(getAverage(grades));
	}
	
	public void printLowestForEach(){

		
		for (int x =0; x< numStudents;x++ ){
			System.out.print(nameGrades[x].getStudentName());
			for (int y = 0; y < numGrades; y++){
				System.out.print(" " +nameGrades[x].getLowest(getGrades()[y]);
			}
			System.out.println("");
		}
	}
	
public void printHighestForEach(){

		
		for (int x =0; x< numStudents;x++ ){
			System.out.print(nameGrades[x].getStudentName());
			for (int y = 0; y < numGrades; y++){
				System.out.print(" " +nameGrades[x].getHighest(getGrades()[y]);
			}
			System.out.println("");
		}
	}

public void printAverageForEach(){

	
	for (int x =0; x< numStudents;x++ ){
		System.out.print(nameGrades[x].getStudentName());
		for (int y = 0; y < numGrades; y++){
			System.out.print(" " +nameGrades[x].getLowest(getAverage()[y]);
		}
		System.out.println("");
	}
}

}
