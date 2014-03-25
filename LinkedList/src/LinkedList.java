
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
		return size;
	}
	
	
	public boolean isEmpty(){
    	/*
    	*  Purpose: Check to see if the list contains 0 elements
    	*  Preconditions: None
    	*  Postconditions: return true if the list is empty, false otherwise
    	*/
		if (first == null) {
			return true;
		}
		return false;
	}
	public void add(Node n){
    	/*
    	*  Purpose: Add a node to the list
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
		if (!isEmpty()){
			n.next = first;
		}
		first = n;
		size += 1;
	}
	
	public boolean addAt(Node n, int index){
    	/*
    	*  Purpose: Add a node after the specified index
    	*  Preconditions: None
    	*  Postconditions: return true if the node was able to be inserted
    	*/
		Node node  = first;
		int currentIndex = 0;
		Node nodeToInsertAfter = null;
		while (node != null && nodeToInsertAfter == null){
			if (index == currentIndex){
				nodeToInsertAfter = node;
			}
			else{
				node = node.next;
				currentIndex++;
			}
		}
		if (nodeToInsertAfter == null){
			return false;
		}
		n.next = nodeToInsertAfter.next;
		nodeToInsertAfter.next = n;
		size ++;
		return true;
	}
	
	
	public void traverseAndPrint(){
    	/*
    	*  Purpose: Traverse the list and print out its contents
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/
		Node ref = first;
		while (ref != null){
			System.out.println(ref.toString());
			ref = ref.next;
		}

	}
	public int find(String value){
    	/*
    	*  Purpose: Find the index of the node containing the specified string
    	*  Preconditions: None
    	*  Postconditions: return index with the node, or -1 if it was not found
    	*/
		Node ref = first;
		int index = 0;
		while (ref != null){
			if (value == ref.value){
				return index;
			}
			ref = ref.next;
			index ++;
		}
		return -1;
	}
	public boolean removeValue(String value){
    	/*
    	*  Purpose: Remove a node containing the specified string value
    	*  Preconditions: None
    	*  Postconditions: return true if the node was removed, false otherwise
    	*/
		
		int index = find(value);
		if (index == -1){
			return false;
		}
		return removeAt(index);

	}
	
	public boolean removeAt(int index){
    	/*
    	*  Purpose: Remove the node at the specified index
    	*  Preconditions: None
    	*  Postconditions: return true if the node was removed, false otherwise
    	*/
		Node n = first;
		int currentIndex = 0;
		Node nodeToRemove = null;
		Node previousNode = null;
		
		while (n!= null && nodeToRemove == null){
			if (index == currentIndex){
				nodeToRemove = n;
			}
			else{
				previousNode = n;
				n=n.next;
				currentIndex++;
			}
		}
		if (nodeToRemove == null)
			return false;
		if (nodeToRemove == first){
			first = first.next;
			size--;
		}
		else if (nodeToRemove.next == null){
			previousNode.next = null;
			size--;
		}
		else{
			previousNode.next = nodeToRemove.next;
			size--;
		}
		return true;
	}
}



















