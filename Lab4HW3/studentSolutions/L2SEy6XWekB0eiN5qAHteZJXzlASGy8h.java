
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


	public  void processFile(String fileName){
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
	public int lowestNamegrades(){         //I thought grades with names and grades without names were different 
		int minNamegrades = 101;				// numbers so I made two methods to find the lowest for each
		for (int x =0; x< numStudents;x++ )		//and then compared the two in the print method.
		{										// it was completely pointless.  Anyways here's the method to find
			for (int y = 0; y < numGrades; y++) //the lowest grade in the Namegrades array
			{
				
				if (nameGrades[x].getGrades()[y]<minNamegrades)
				{
					minNamegrades = nameGrades[x].getGrades()[y];
				}
			}
		}
		return minNamegrades;
	}
	
	public int lowestGrades( ){					// this method finds the lowest grade in the Grades array
		int minGrades = 101;					// which is the same value as the method above cause
												//the numbers are the same and I didn't realize that
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				
				if(grades[x][y]<minGrades){     //minGrades is set at 101,  this statement replaces it with whatever
					minGrades = grades[x][y];   // comes along in the array that is lower
					
				}
				
			}
				
			
	}
		return minGrades;
		
}
	public void printLowestScore(int x, int y)  //this takes the minimum of Grades and NameGrades and prints the 
	{											// lowest one.  Once again, it was unnecessary to compare anything
		if (x<=y)								// because Grades and NameGrades have the same numbers.
		{
			System.out.println("Lowest: " +x);
		}
		System.out.println("");
	}
	public int highestNamegrades(){			//I made the same mistake when I was working on this method. I thought the 
		int maxNamegrades = 0;				// arrays were different, but they're the same.
		for (int x =0; x< numStudents;x++ )  // Anyways I got it to work by basically doing the opposite of finding the lowest.
		{									// Line 161 sets the max at zero
			for (int y = 0; y < numGrades; y++)
			{
				
				if (nameGrades[x].getGrades()[y]>maxNamegrades)// this statement replaces the max with whatever number is larger
				{
					maxNamegrades = nameGrades[x].getGrades()[y];
				}
			}
		}
		return maxNamegrades;
	}
	
	public int highestGrades( ){           //see highestNameGrades method. same thing here.
		int maxGrades = 0;
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				
				if(grades[x][y]>maxGrades){
					maxGrades = grades[x][y];
					
				}
				
			}
				
			
	}
		return maxGrades;
		
}
	public void printHighestScore(int x, int y)
	{
		if (x>=y)							// if statement compares max of Grades and max of NameGrades and
		{									// prints lower number. once again, it's pointless to compare
			System.out.println("Highest: " +x);
		}
		System.out.println("");
	}
	public int avgGrades()          //This is where I realized the numbers were the same and i was able to
	{								// stop doing everything twice
		
		int sum = 0;   // make variable sum
		
		for (int x =0; x< numStudents;x++ ){
			for (int y = 0; y < numGrades; y++){
				
				sum+=grades[x][y];      //sum the array
					
				}
				
			}
		return (sum/(numStudents*numGrades));  //return average
		
	}
	public void printAverageScore(int x) // print average
	{
		System.out.println("Average: "+ x);
		System.out.println("");
	}
	
	
	public int findLowest(int x)   //basically the same as finding the overall minimum
	{							//except you pass in x so that you can select which student 
		int min = 101;			// youre getting the lowest for
		
			for (int y = 0; y < numGrades; y++){
				
				if(nameGrades[x].getGrades()[y]<min)
				{
					min = nameGrades[x].getGrades()[y];
				}
				
			}
			return (min);
			
			
		}
	public void printLowestForEachStudent() // uses findLowest method to print lowest score
	{
		
		for (int x =0; x< numStudents;x++ ){
			System.out.println(nameGrades[x].getStudentName()+" Lowest: "+ findLowest(x)+ " ");
		
		}
		System.out.println(" ");
	}
	
	public int findHighest(int x) //same process as finding lowest just backwards
	{
		int max = 0;
		
			for (int y = 0; y < numGrades; y++){
				
				if(nameGrades[x].getGrades()[y]>max)
				{
					max = nameGrades[x].getGrades()[y];
				}
				
			}
			return (max);
			
			
		}
	
	public void printHighestForEachStudent()
	{
		
		for (int x =0; x< numStudents;x++ ){
			System.out.println(nameGrades[x].getStudentName()+" Highest: "+ findHighest(x)+ " ");
		
		}
		System.out.println(" ");
	}
	
	public int findAvgEachStu(int x)   // similar to finding overall avg
	{
		int sum = 0;
		
			for (int y = 0; y < numGrades; y++){
				
				
					sum += nameGrades[x].getGrades()[y];
				
				
			}
			return (sum/numGrades);
			
			
		}
	
	public void printAverageScoreForEachStudent()
	{
		
	
	for (int x =0; x< numStudents;x++ ){
		System.out.println(nameGrades[x].getStudentName()+" Average: "+ findAvgEachStu(x)+ " ");
	
	}
	
	}
}


	
	


