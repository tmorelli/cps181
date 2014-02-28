
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grades {
/**
* @ author Tony Morelli
* @throws None
*
* Date: 20 February 2014
* Purpose: Handles Grade related data
* Uses:
*
*/
static int numStudents = 5;
static int numGrades = 5;
int [][] grades = new int[numStudents][numGrades];
NameGrades[] nameGrades = new NameGrades[numStudents];


public void processFile(String fileName){
/*
* Purpose: Read in the file and populate members
* Preconditions: none
* Postconditions: none
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
* Purpose: Read in the file (with names as first column) and populate members
* Preconditions: none
* Postconditions: none
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
* Purpose: Print out grades
* Preconditions: none
* Postconditions: none
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
* Purpose: Print out grades and names
* Preconditions: none
* Postconditions: none
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
	int minScore = 100;
	for (int x =0; x< numStudents;x++ ){
		for (int y = 0; y < numGrades; y++){
			if( grades[x][y] <= minScore ){
				minScore = grades[x][y];
			}
		}
	}
	System.out.println("Lowest Grade: "+ minScore);
}

public void printHighestScore(){
	int maxScore = 0;
	for (int x =0; x< numStudents;x++ ){
		for (int y = 0; y < numGrades; y++){
			if( grades[x][y] >= maxScore ){
				maxScore = grades[x][y];
			}
		}
	}
	System.out.println("Highest Grade: "+ maxScore);
}

public void printAverageScore(){
	int total = 0;
	for (int x =0; x< numStudents;x++ ){
		for (int y = 0; y < numGrades; y++){
			total +=  grades[x][y];
		} 
		
	}
	double avg = (double) total / (numGrades * numStudents);
	System.out.println("Average Score: " + avg );
}

public void printLowestForEachStudent(){
	int minScore = 100;
	for (int x = 0; x < numStudents;x++ ){
		System.out.print(nameGrades[x].getStudentName());
		for (int y = 0; y < numGrades; y++){
			if( grades[x][y] <= minScore ){
				minScore = grades[x][y];
			}
		}
		System.out.println("'s Lowest Grade: "+ minScore);
		minScore = 100;
	}
}

public void printHighestForEachStudent(){
	int maxScore = 0;
	for (int x = 0; x < numStudents;x++ ){
		System.out.print(nameGrades[x].getStudentName());
		for (int y = 0; y < numGrades; y++){
			if( grades[x][y] >= maxScore ){
				maxScore = grades[x][y];
			}
		}
		System.out.println("'s Highest Grade: "+ maxScore);
		maxScore = 0;
	}
}

public void printAverageScoreForEachStudent(){
	int total = 0;
	for (int x =0; x< numStudents;x++ ){
		System.out.print(nameGrades[x].getStudentName());
		for (int y = 0; y < numGrades; y++){
			total +=  grades[x][y];
		} 
		double avg = (double) total / (numGrades);
		System.out.println("'s Average Score: " + avg );
		total = 0;
	}
	
}

}