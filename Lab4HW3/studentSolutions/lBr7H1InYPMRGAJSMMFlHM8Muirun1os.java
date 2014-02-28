import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Grades {
	
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

	
	@SuppressWarnings("resource")
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
		//read.close();
	}


	public void printGrades(){
		// not sure if this was still necessary for the homework
		//, but I left it in so that the user can see all of the grades with names.
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
		int lowest = 0;
		
		for(int x = 0; x<numStudents; x++){
			for(int y =0; y<numGrades; y++){
				if(grades[x][y] < lowest){
					lowest=grades[x][y];
					
				}
				
			}
		}
		System.out.println("Lowest Score is: " + lowest);
		
		
		
		
	}
	public void printHighestScore(){
		int highest = 0;
		for(int x = 0; x<numStudents; x++){
			for(int y =0; y<numGrades; y++){
				if(grades[x][y] > highest){
					highest=grades[x][y];
					
				}
				
			}
		}
		System.out.println("Highest Score is: " + highest);
	}
	
	
	public void printAverageScore(){
		double average;
		int total=0;
		int count=0;
		for(int x = 0; x<numStudents; x++){
			for(int y =0; y<numGrades; y++){
				total+=grades[x][y];
				count++;
			}
	    }
		
		average= (double)total/(double)count;
		System.out.println("The Average score: " + average);
	
}
	
	public void printLowestForEachStudent(){
		int lowest=0;
		//int swap;
		for(int x =0; x<numStudents; x++){
			
				int y=0;
				int [] sorter = new int[numStudents];
				for(int xx=0; xx<numStudents; xx++){
					sorter[xx]=grades[x][y];
					y++;
				}
				Arrays.sort(sorter);
				lowest= sorter[0];
				
				System.out.println(nameGrades[x].getStudentName() + " Lowest Score is " + lowest);
					
		}
				
				
				
				
	}
			
	public void printHighestForEachStudent(){
		
		int highest=0;
		//int swap;
		for(int x =0; x<numStudents; x++){
			
				int y=0;
				int [] sorter = new int[numStudents];
				for(int xx=0; xx<numStudents; xx++){
					sorter[xx]=grades[x][y];
					y++;
				}
				Arrays.sort(sorter);
				highest= sorter[4];
				
				System.out.println(nameGrades[x].getStudentName() + " Highest Score is " + highest);
					
		}
				
				
				
	}
	public void printAverageScoreForEachStudent(){
		
		double average;
		
		//int swap;
		for(int x =0; x<numStudents; x++){
			int sum= 0;
			for(int y=0; y<numGrades;y++){
				sum+= grades[x][y];
				
			}
			
			average= (double)sum/(double)numGrades;
			System.out.println(nameGrades[x].getStudentName() + " Average Score is " +average);
		}
	}
		
	}


