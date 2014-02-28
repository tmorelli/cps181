import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grades {
	static int numStudents = 5;
	static int numGrades = 5;
	int[][] grades = new int[numStudents][numGrades];
	NameGrades[] nameGrades = new NameGrades[numStudents];

	public void processFile(String fileName) {
		/*
		 * Purpose: Read in the file and populate members Preconditions: none
		 * Postconditions: none
		 */
		Scanner read;
		File logFile = new File(fileName);

		try {
			read = new Scanner(logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		int totalStudents = 0;
		while (read.hasNextLine()) {
			String line = read.nextLine();
			String[] values = line.split(",");
			for (int x = 0; x < numGrades; x++) {
				grades[totalStudents][x] = Integer.parseInt(values[x]);
			}
			totalStudents++;
		}
		read.close();
	}

	public void processFileWithNames(String fileName) {
		/*
		 * Purpose: Read in the file (with names as first column) and populate
		 * members Preconditions: none Postconditions: none
		 */
		Scanner read;
		File logFile = new File(fileName);

		try {
			read = new Scanner(logFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		int totalStudents = 0;
		while (read.hasNextLine()) {
			String line = read.nextLine();
			String[] values = line.split(",");
			int[] g = new int[numGrades];
			String name = values[0];
			for (int x = 1; x < numGrades + 1; x++) {
				g[x - 1] = Integer.parseInt(values[x]);
			}
			nameGrades[totalStudents] = new NameGrades();
			nameGrades[totalStudents].setStudentName(name);
			nameGrades[totalStudents].setGrades(g);
			totalStudents++;
		}
		read.close();
	}

	public void printGrades() {
		/*
		 * Purpose: Print out grades Preconditions: none Postconditions: none
		 */
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {
				System.out.print(" " + grades[x][y]);
			}
			System.out.println("");
		}
	}

	public void printGradesWithNames() {
		/*
		 * Purpose: Print out grades and names Preconditions: none
		 * Postconditions: none
		 */
		for (int x = 0; x < numStudents; x++) {
			System.out.print(nameGrades[x].getStudentName());
			for (int y = 0; y < numGrades; y++) {
				System.out.print(" " + nameGrades[x].getGrades()[y]);
			}
			System.out.println("");
		}
	}

	public void printLowestScore() {

		int min = 100;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {

				if (grades[x][y] <= min) {
					min = grades[x][y];

				}

			}

		}
		System.out.println("The lowest score is: " + min);
	}

	public void printHighestScore() {
		int max = 0;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {

				if (grades[x][y] >= max) {
					max = grades[x][y];

				}

			}
		}
		System.out.println("The highest score is: " + max);
	}

	public void printAverageScore() {
		int sum = 0;
		for (int x = 0; x < numStudents; x++) {
			for (int y = 0; y < numGrades; y++) {

				sum = sum + grades[x][y];

			}

		}

		System.out.println("The average score is: " + (double) sum
				/ (numStudents * numGrades));

	}

	public void printLowestForEachStudent() {
		int minInRow;
		for (int x = 0; x < numStudents; x++) {
			minInRow = grades[x][0];
			for (int y = 0; y < numGrades; y++) {
				if (minInRow > grades[x][y]) {
					minInRow = grades[x][y];
				}

			}
			System.out.println(nameGrades[x].getStudentName()
					+ "'s lowest score: " + minInRow);
		}

	}

	public void printHighestForEachStudent() {
		int maxInRow;
		for (int x = 0; x < numStudents; x++) {
			maxInRow = grades[x][0];
			for (int y = 0; y < numGrades; y++) {
				if (maxInRow < grades[x][y]) {
					maxInRow = grades[x][y];
				}

			}
			System.out.println(nameGrades[x].getStudentName()
					+ "'s highest score: " + maxInRow);
		}
	}

	public void printAverageScoreForEachStudent() {
		int sum;
		for (int x = 0; x < numStudents; x++) {
			sum = 0;
			for (int y = 0; y < numGrades; y++) {

				sum = sum + grades[x][y];

			}
			System.out.println(nameGrades[x].getStudentName()
					+ "'s average score: " + (double) sum / (numGrades));
		}

	}
}
