package lab4;

public class NameGrades {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		20 February 2014
	 *  Purpose: 	Handles Grade related data with names	
	 *  Uses:		 
	 *  
	 */
	private static int numGrades = 5;
	private int [] grades = new int [numGrades];
	private String studentName;

	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
