package lab4;

public class Main {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		20 February 2014
	 *  Purpose: 	Main class for lab 4	
	 *  Uses:		 
	 *  
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grades grades = new Grades();

		grades.processFile("grades.txt");
		grades.printGrades();

		
		grades.processFileWithNames("gradesAndNames.txt");
		grades.printGradesWithNames();

		
		
/*
 * Homework #3		
		grades.printLowestScore();
		grades.printHighestScore();
		grades.printAverageScore();
		grades.printLowestForEachStudent();
		grades.printHighestForEachStudent();
		grades.printAverageScoreForEachStudent();
		
*/

	}

}
