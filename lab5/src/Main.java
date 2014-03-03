
public class Main {

	/**
	 *	@ author Tony Morelli
	 *	@throws None 
	 *	
	 * 	Date: 		28 February 2014
	 *  Purpose: 	Main class for Lab5
	 *  Uses:		
	 *  
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    /*
    	*  Purpose: Demonstrate the program requirements
    	*  Preconditions: None
    	*  Postconditions: return nothing
    	*/

		// TODO Auto-generated method stub
		
		printSequence(0,10);
		System.out.println("");
		printRecursiveSequence(0,10);
		System.out.println("");
		System.out.println(factorial(5));
		System.out.println(nonFactorial(5));
		
		int [] x = {1,2,3,4,5,6,7,8,9};
		System.out.println(rangeAverage(x,3,6));

	}

	public static double rangeAverage(int [] x, int start, int end){
		/*
    	*  Purpose: Average numbers over a certain range
    	*  Preconditions: Array of ints, start index, and end index
    	*  Postconditions: return average
    	*/


		return (double)((double)sumRange(x,start,end) / (double)(end-start+1));
		
	}
	
	public static int sumRange(int [] x, int start, int end){

		/*
    	*  Purpose: Sum numbers over a certain range
    	*  Preconditions: Array of ints, start index, and end index
    	*  Postconditions: return sum
    	*/

		if (start > end){
			return 0;
		}
		return x[start] + sumRange(x,start+1,end);
	}
	
	public static int nonFactorial (int num){
		/*
    	*  Purpose: Perform factorial without using recursion
    	*  Preconditions: Number to perform factorial
    	*  Postconditions: return factorial
    	*/

		int result = 1;
		for (int x = 1; x<= num; x++)
			result *=x;
		return result;
	}
	
	public static int factorial (int num){
		/*
    	*  Purpose: Perform factorial  using recursion
    	*  Preconditions: Number to perform factorial
    	*  Postconditions: return factorial
    	*/
		if (num == 0)
			return 1;
		return num * factorial(num-1);
	}
	
	public static void printRecursiveSequence(int start, int finish){
		/*
    	*  Purpose: Print sequence of numbers in multiple of 2s
    	*  Preconditions: Start and finish number
    	*  Postconditions: return nothing
    	*/

		System.out.print(" "+start);
		if (start< finish)
			printRecursiveSequence(start+2,finish);
	}
	
	public static void printSequence(int start, int finish){
		/*
    	*  Purpose: Print sequence of numbers in multiple of 2s without recursion
    	*  Preconditions: Start and finish number
    	*  Postconditions: return nothing
    	*/
		for (int x = start; x<= finish; x+=2)
			System.out.print(" "+x);
	}

}
