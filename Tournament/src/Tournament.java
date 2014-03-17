import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Tournament {

	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 March 2014
	 *  Purpose: 	Tournament class for simulating bracketed tournaments with seeds	
	 *  Uses:		
	 *  
	 */
	String filename;
	Random rand = new Random(0);
	public  Tournament (String filename){
		/*
    	*  Purpose: Construct a tournament given a file containing the starting brackets
    	*  Preconditions: None
    	*  Postconditions: None
    	*/

		this.filename = filename;
	}
	public void playTournament() {
		/*
    	*  Purpose: Play through a bracketed single elimination tournament
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
		LinkedList list = new LinkedList();	
		initLinkedList(list, filename);
		
		while(list.size() != 1){
			list = playRound(list);
			list.traverseAndPrint();
			System.out.println("\n");
		}
	}
	public LinkedList playRound(LinkedList list){
		/*
    	*  Purpose: Play one round
    	*  Preconditions: Linked list containing tournament brackets
    	*  Postconditions: Linked list containing the winners
    	*/

		return null;
	}
	public  void initLinkedList(LinkedList l, String filename){
		/*
    	*  Purpose: Read in the initial brackets from a file and store it in a linked list
    	*  Preconditions: None
    	*  Postconditions: None
    	*/

	}
}
