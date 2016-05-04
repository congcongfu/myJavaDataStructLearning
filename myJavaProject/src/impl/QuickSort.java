package impl;


public class QuickSort {

	private int [] theArray;
	private int count;
	
	/**
	 * Constructor
	 * Creates a new QuickSort
	 * */
	public QuickSort(int max){
		theArray = new int[max];
		count = 0;
	}
	
	/**
	 * Insert a new number into the array
	 * @param number to be inserted
	 * */
	public void insert(int value){
		theArray[count] = value;
		count++;
	}
	
	/**
	 * Display the array
	 * */
	public void display(){
		System.out.println("A=");
		for(int i = 0; i < count; i++)
			System.out.println(theArray[i] +" ");
		System.out.println(" ");
			
	}
	
	/**
	 * Returns a string to represents the array
	 * @returns a string to represents the array
	 * */
	public String toString(){
		String result = "{";
		for (int i = 0; i < count; i++) {
			if(i  < count -1){
				result += theArray[i] +",";
			}
			else
				result += theArray[i];
		}
		return result + "}";
	}
	
	/**
	 * Sorts the array
	 * 
	 * */
	public void quickSort(){
		recQuickSort(0, count - 1);
	}

	/**
	 * Reorder the sort
	 * */
	private void recQuickSort(int left, int right) {
		if(right <= left)
			return;
		else {
			int pivot = theArray[right];
			int partition = partiotionIt(left, right , pivot);
			recQuickSort(left, partition -1);
			recQuickSort(partition +1, right);
		}
	}
	
	
	/**
	 * Partition the array into two part according to pivot
	 * */
	private int partiotionIt(int left, int right, int pivot) {
		int leftPtr = left;
		int rightPtr = right ;
		while(true){
			while(leftPtr < rightPtr &&
					theArray[leftPtr] < pivot)
				++leftPtr;
			while(rightPtr > leftPtr && 
					theArray[rightPtr] > pivot)
				--rightPtr;
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		return leftPtr;
	}

	/**
	 *Exchange the value of the two position
	 * */
	private void swap(int left, int right) {
		int temp = theArray[left];
		theArray[left] = theArray[right];
		theArray[right] = temp;
	}
	
	
	
}
















