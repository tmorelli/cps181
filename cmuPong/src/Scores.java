import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Scores {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 January 2014
	 *  Purpose: 	Handles storing and retrieving scores	
	 *  Uses:		 
	 *  
	 */

	
	static String allScoresFilename = "allscores.txt";
	static String lastScoreFilename = "lastscores.txt";
	
	int totalScoresRead = 0;
	public int MAX_SCORES = 100;
	
	public boolean writeScores(int player1Score, int player2Score){
    	/*
    	*  Purpose: Write the score to a file
    	*  Preconditions: player 1 and 2 scores
    	*  Postconditions: return true if written to file, false otherwise
    	*/

		BufferedWriter writer = null;
		try {
			File logFile = new File(lastScoreFilename);

			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write(player1Score+","+player2Score+"\n");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}//End writeScores
	public boolean appendScores(int player1Score, int player2Score){
    	/*
    	*  Purpose: Append scores to a file
    	*  Preconditions: player1 and 2 scores
    	*  Postconditions: return true if written to a file, false otherwise
    	*/
		BufferedWriter writer = null;
		try {
			File logFile = new File(allScoresFilename);

			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile,true));
			writer.write(player1Score+","+player2Score+"\n");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}//End appendScores
	public void readScores(){
    	/*
    	*  Purpose: readScores from a file
    	*  Preconditions: none
    	*  Postconditions: return nothing
    	*/
		Scanner read;
		try {
			read = new Scanner (new File(allScoresFilename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}


/*
 * Question 8		
		while (read.hasNextLine())
		{
		   String line = read.nextLine();
		   System.out.println(line);
		}
*/
// Question 9		
		int player1Scores[] = new int[MAX_SCORES];
		int player2Scores[] = new int[MAX_SCORES];
		while (read.hasNextLine())
		{
			String line = read.nextLine();
			String [] scores = line.split(",");
			player1Scores[totalScoresRead] = Integer.parseInt(scores[0]);
			player2Scores[totalScoresRead] = Integer.parseInt(scores[1]);
			
			totalScoresRead ++;
			if (totalScoresRead == MAX_SCORES){
				break;
			}
		}
		read.close();
		
		//Question 10:
		calculateWinners(player1Scores, player2Scores);
	}//End readScores
	
	public void calculateWinners(int [] _player1, int [] _player2){
    	/*
    	*  Purpose: Print out number of times player1 wins and player2 wins
    	*  Preconditions: none
    	*  Postconditions: return nothing
    	*/
		int player1Wins = 0;
		int player2Wins = 0;
		for (int x = 0; x< totalScoresRead; x++){
			if (_player1[x] > _player2[x]){
				player1Wins++;
				
			}
			else{
				player2Wins++;
			}
		}
		System.out.println("Player1 Wins: " + player1Wins + ", Player2 Wins: "+player2Wins);
	}//End calculateWinners
}

