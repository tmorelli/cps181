public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printSequence(0,10);
		System.out.println("");
		printRecursiveSequence(0,10);
		System.out.println("");
		System.out.println(factorial(6));
		System.out.println(nonFactorial(5));
		
		int [] x = {1,2,3,4,5,6,7,8,9};
		System.out.println(rangeAverage(x,3,6));

	}

	public static double rangeAverage(int [] x, int start, int end){
		return (double)((double)sumRange(x,start,end) / (double)(end-start+1));
		
	}
	
	public static int sumRange(int [] x, int start, int end){
		if (start > end){
			return 0;
		}
		return x[start] + sumRange(x,start+1,end);
	}
	
	public static int nonFactorial (int num){
		int result = 1;
		for (int x = 1; x<= num; x++)
			result *=x;
		return result;
	}
	
	public static int factorial (int num){
		if (num == 0)
			return 1;
		return num * factorial(num-1);
	}
	
	public static void printRecursiveSequence(int start, int finish){
		System.out.print(" "+start);
		if (start< finish)
			printRecursiveSequence(start+2,finish);
	}
	
	public static void printSequence(int start, int finish){
		for (int x = start; x<= finish; x+=2)
			System.out.print(" "+x);
	}

}

