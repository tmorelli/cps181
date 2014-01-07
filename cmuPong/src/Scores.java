import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


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
	
	public boolean writeScores(int player1Score, int player2Score){
    	/*
    	*  Purpose: Write the score to a file
    	*  Preconditions: player 1 and 2 scores
    	*  Postconditions: return true if written to file, false otherwise
    	*/

		return true;
	}//End writeScores
	public boolean appendScores(int player1Score, int player2Score){
    	/*
    	*  Purpose: Append scores to a file
    	*  Preconditions: player1 and 2 scores
    	*  Postconditions: return true if written to a file, false otherwise
    	*/
		return true;
	}//End appendScores
	public void readScores(){
    	/*
    	*  Purpose: readScores from a file
    	*  Preconditions: none
    	*  Postconditions: return nothing
    	*/

	}//End readScores
}

