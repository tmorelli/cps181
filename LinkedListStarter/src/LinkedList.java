
public class LinkedList {
	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		1 March 2014
	 *  Purpose: 	Linked list container class to access nodes in a linked list	
	 *  Uses:		
	 *  
	 */

	Node first = null;
	Node last = null;
	int size = 0;
	
	
	public int size(){
    	/*
    	*  Purpose: Return the number of elements in a linked list
    	*  Preconditions: None
    	*  Postconditions: return the size
    	*/
		return 0;
	}
	
	
	public boolean isEmpty(){
    	/*
    	*  Purpose: Check to see if the list contains 0 elements
    	*  Preconditions: None
    	*  Postconditions: return true if the list is empty, false otherwise
    	*/
	
		return false;
	}
	public void add(Node n){
    	/*
    	*  Purpose: Add a node to the list
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
		if (isEmpty()){
			n.next = first;
		}

		first = n;
		
	}
	
	
	public void traverseAndPrint(){
    	/*
    	*  Purpose: Traverse the list and print out its contents
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
	

	}

}



















