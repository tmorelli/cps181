
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
	String value;
	Node next = null;
	Node (String value){
    	/*
    	*  Purpose: Construct a node object with a value of the passed in string
    	*  Preconditions: None
    	*  Postconditions: None
    	*/
		this.value = value;
	}
	public String toString(){
    	/*
    	*  Purpose: Return a string representation of this object
    	*  Preconditions: None
    	*  Postconditions: return a string representation of this object
    	*/

		return value;
	}
	
}
