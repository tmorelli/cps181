
public class Node {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 March 2014
	 *  Purpose: 	Node class for a linked list element	
	 *  Uses:		
	 *  
	 */

	public int seed;
	public String name;
	public Node next = null;
	public Node (int seed, String name){
		/*
    	*  Purpose: Construct a node object with a value of the passed in string and the seed
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
		this.seed = seed;
		this.name = name;
	}
	public Node (Node n){
		/*
    	*  Purpose: Copy Constructor
    	*  Preconditions: None
    	*  Postconditions: None
    	*/

		this.seed = n.seed;
		this.name = n.name;
	}
	public Node (){
		/*
    	*  Purpose: Default Constructor
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
	
	}
}
