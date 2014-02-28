import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Grades {
	
	 static int numStudents = 5;
	 static int numGrades = 5;
	 int [][] grades = new int[numStudents][numGrades];
	 NameGrades[] nameGrades = new NameGrades[numStudents];
	
	public	void processFile(String fileName){	
		 Scanner read;
		 File logFile = new File(fileName);
		 
		 try {
			 read = new Scanner(logFile);
		 } catch (FileNotFoundException e ) {
			 e.printStackTrace();
			 return;
		 }
		 
		 int totalStudents = 0;
		 while (read.hasNextLine()) {
			 String line = read.nextLine();
			 String [] values = line.split(",");
			 for (int x = 0; x < numGrades; x++) {
				 grades[totalStudents][x] = Integer.parseInt(values[x]);
				 
			 }
			 totalStudents++;
		 }
		 read.close();
	}
	
	public void processFileWithNames(String fileName){	
		Scanner read;
		File logFile = new File(fileName);
		
		try {
			read = new Scanner(logFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int totalStudents = 0;
		while (read.hasNextLine()) {
			String line = read.nextLine();
			String [] values = line.split(",");
			int [] g = new int[numGrades];
			String name = values[0];
			for (int x = 1; x < numGrades+1; x++) {
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
		 for (int x = 0; x < numStudents; x++) {
			 for (int y = 0; y < numGrades; y++) {
				 System.out.print(" " + grades[x][y]);
			 }
			 System.out.println("");
		 }
		 System.out.println("");
	}
	
	public void printGradesWithNames(){	
		for (int x = 0; x < numStudents; x++) {
			System.out.print(nameGrades[x].getStudentName());
			for (int y = 0; y < numGrades; y++) {
				System.out.print(" " + nameGrades[x].getGrades()[y]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void printLowestScore() {
		int lowScore = 100;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {
				if (grades[x][y] < lowScore) {
					lowScore = grades[x][y];
				}
			}
		}
		
		System.out.println("Group's lowest score is: " + lowScore);
		System.out.println("");
		
	}
	
	public void printHighestScore() {
		int highScore = 0;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {
				if (grades[x][y] > highScore) {
					highScore = grades[x][y];
				}
			}
		}
		
		System.out.println("Group's highest score is: " + highScore);
		System.out.println("");
	}
	
	public void printAverageScore() {
		int countScores = 0;
		int average = 0;
		int addScores = 0;
		
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {
				countScores++;
				addScores+= grades[x][y];
			}
		}
		
		average = addScores / countScores;
		
		System.out.println("Group's average score is: " + average);
		System.out.println("");
		
	}
	
	public void printLowestForEachStudent() {
		int lowScore = 100;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < 5; y++) {
				if (grades[x][y] < lowScore) {
					lowScore = grades[x][y];
				}
			}
			System.out.println(nameGrades[x].getStudentName() + "'s lowest score is: " + lowScore);
			lowScore = 100;
		}
		System.out.println("");
	}
	
	public void printHighestForEachStudent() {
		int highScore = 0;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < 5; y++) {
				if (grades[x][y] > highScore) {
					highScore = grades[x][y];
				}
			}
			System.out.println(nameGrades[x].getStudentName() + "'s highest score is: " + highScore);
			highScore = 0;
		}
		System.out.println("");
	}
	
	public void printAverageScoreForEachStudent() {
		int countScores = 0;
		int average = 0;
		int addScores = 0;
		
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < 5; y++) {
				countScores++;
				addScores+= grades[x][y];
			}
			average = addScores / countScores;
			
			System.out.println(nameGrades[x].getStudentName() + "'s average score is: " + average);
			
			average = 0;
			addScores = 0;
			countScores = 0;
		}
		

	}
	
	

}
