public class Main {
	public static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x[] = { 4, 3, 7, 8, 3, 5, 2, 3, 9, 2, 1, 0, 44, 3, 22 };
		printArray(x);
		quickSort(x, 0, x.length);
		printArray(x);
	}
	/*****************************************************************/
	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot);
			quickSort(array, pivot + 1, end);
		}
	}
	/*****************************************************************/
	public static int partition(int array[], int start, int end) {
		return 0;
	}
	/*****************************************************************/
















	/*****************************************************************/
	public static void sortArray(int[] array) {

	
	}

	/*****************************************************************/

	public static void printArray(int[] array) {
		for (int x = 0; x < array.length; x++) {
			System.out.println(array[x]);
		}
	}
	/*****************************************************************/
	public static void bubbleSort(int[] array) {
		int comparisons = 0;
		for (int x = array.length - 1; x >= 0; x--) {
			for (int y = 0; y < x; y++) {
				comparisons++;
				if (array[y] > array[y + 1]) {
					int temp = array[y];
					array[y] = array[y + 1];
					array[y + 1] = temp;
				}
			}
		}
		System.out.println("Comparisons: " + comparisons);
		printArray(array);
	}
	/*****************************************************************/
	public static void selectionSort(int [] array){
		for (int x =0; x< array.length; x++){
			int smallest = array[x];
			int smallestIndex = x;
			for (int y = x; y< array.length; y++){
				if (array[y] < smallest){
					smallest = array[y];
					smallestIndex = y;
				}
			}
			int temp = array[x];
			array[x] = array[smallestIndex];
			array[smallestIndex] = temp;		
		}
	}
	
}
