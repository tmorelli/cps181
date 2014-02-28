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

	public void printLowestScore() {
		
		int LowestScore = 100;
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[x][y] < LowestScore){
					LowestScore = grades[x][y];
				}
			}
			
		}
	   
	 System.out.println("Lowest of all Scores " + LowestScore);
		
	}

	public void printHighestScore() {
		// TODO Auto-generated method stub
		
int HighestScore = 0;
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[x][y] >= HighestScore){
					HighestScore = grades[x][y];
				}
			}
			
		}
	   
	 System.out.println("Highest of all Scores " + HighestScore);
		
	}
		
	

	public void printAverageScore() {
		int AverageScore = 0;
     for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
                AverageScore = (AverageScore + grades[x][y]);	
                
			}
     }
      AverageScore = AverageScore/(numStudents * numGrades);
        System.out.println("Average of all scores " + AverageScore);
	}

	public void printLowestForEachStudent() {
		// TODO Auto-generated method stub
		int St1LowestScore = 100;
		int St2LowestScore = 100;
		int St3LowestScore = 100;
		int St4LowestScore = 100;
		int St5LowestScore = 100;
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[0][y] < St1LowestScore){
					St1LowestScore = grades[0][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[1][y] < St2LowestScore){
					St2LowestScore = grades[1][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[2][y] < St3LowestScore){
					St3LowestScore = grades[2][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[3][y] < St4LowestScore){
					St4LowestScore = grades[3][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[4][y] < St5LowestScore){
					St5LowestScore = grades[4][y];
				}
			}
		}
		System.out.println("Studetn 1 Lowest Score " + St1LowestScore);
		System.out.println("Studetn 2 Lowest Score " + St2LowestScore);
		System.out.println("Studetn 3 Lowest Score " + St3LowestScore);
		System.out.println("Studetn 4 Lowest Score " + St4LowestScore);
		System.out.println("Studetn 5 Lowest Score " + St5LowestScore);
	}

	public void printHighestForEachStudent() {
		// TODO Auto-generated method stub
		int St1HighestScore = 0;
		int St2HighestScore = 0;
		int St3HighestScore = 0;
		int St4HighestScore = 0;
		int St5HighestScore = 0;
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[0][y] > St1HighestScore){
					St1HighestScore = grades[0][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[1][y] > St2HighestScore){
					St2HighestScore = grades[1][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[2][y] > St3HighestScore){
					St3HighestScore = grades[2][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[3][y] > St4HighestScore){
					St4HighestScore = grades[3][y];
				}
			}
		}
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				if (grades[4][y] > St5HighestScore){
					St5HighestScore = grades[4][y];
				}
			}
		}
		
		System.out.println("Studetn 1 Highist Score " + St1HighestScore);
		System.out.println("Studetn 2 Highist Score " + St2HighestScore);
		System.out.println("Studetn 3 Highist Score " + St3HighestScore);
		System.out.println("Studetn 4 Highist Score " + St4HighestScore);
		System.out.println("Studetn 5 Highist Score " + St5HighestScore);
		
	}

	public void printAverageScoreForEachStudent() {
		// TODO Auto-generated method stub
		
		int St1AverageScore = 0;
		int St2AverageScore = 0;
		int St3AverageScore = 0;
		int St4AverageScore = 0;
		int St5AverageScore = 0;

				for (int y = 0; y < numGrades; y++){
	                 St1AverageScore = (St1AverageScore + grades[0][y]);	
	                
			  }
	      St1AverageScore = St1AverageScore/(numGrades);
	      
	      for (int y = 0; y < numGrades; y++){
                    St2AverageScore = (St2AverageScore + grades[1][y]);	
              
		     }
         St2AverageScore = St2AverageScore/(numGrades);
          
         for (int y = 0; y < numGrades; y++){
                   St3AverageScore = (St3AverageScore + grades[2][y]);	
        
            }
         St3AverageScore = St3AverageScore/(numGrades);
          
         for (int y = 0; y < numGrades; y++){
                   St4AverageScore = (St4AverageScore + grades[3][y]);	
    
            }
         St4AverageScore = St4AverageScore/(numGrades);
         
         for (int y = 0; y < numGrades; y++){
                 St5AverageScore = (St5AverageScore + grades[4][y]);	
    
            }
        St5AverageScore = St5AverageScore/(numGrades);
	      
	      
	       System.out.println("Student 1 Average Score " + St1AverageScore);
	       System.out.println("Student 2 Average Score " + St2AverageScore);
	       System.out.println("Student 3 Average Score " + St3AverageScore);
	       System.out.println("Student 4 Average Score " + St4AverageScore);
	       System.out.println("Student 5 Average Score " + St5AverageScore);
		
	}
}