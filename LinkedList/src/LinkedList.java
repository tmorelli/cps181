
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
		return true;
	}
	public void add(Node n){
    	/*
    	*  Purpose: Add a node to the list
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
	}
	
	public boolean addAt(Node n, int index){
    	/*
    	*  Purpose: Add a node after the specified index
    	*  Preconditions: None
    	*  Postconditions: return true if the node was able to be inserted
    	*/
		return false;
	}
	
	
	public void traverseAndPrint(){
    	/*
    	*  Purpose: Traverse the list and print out its contents
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

	}
	public int find(String value){
    	/*
    	*  Purpose: Find the index of the node containing the specified string
    	*  Preconditions: None
    	*  Postconditions: return index with the node, or -1 if it was not found
    	*/
		return -1;
	}
	public boolean removeValue(String value){
    	/*
    	*  Purpose: Remove a node containing the specified string value
    	*  Preconditions: None
    	*  Postconditions: return true if the node was removed, false otherwise
    	*/
		return false;

	}
	
	public boolean removeAt(int index){
    	/*
    	*  Purpose: Remove the node at the specified index
    	*  Preconditions: None
    	*  Postconditions: return true if the node was removed, false otherwise
    	*/
		return false;
	}
}
