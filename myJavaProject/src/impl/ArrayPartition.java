package impl;


public class ArrayPartition {
	
	protected int [] theArray;   //ref to array theArray
	protected int count;         //number of data items
	
	/**
	 * constructor
	 * Create a new ArrayPartition
	 * @param a number to represents the size of the array
	 * */
	public ArrayPartition(int max){
		theArray = new int[max];
		count = 0;
	}
	
	/**
	 * Inserts a number
	 * @param a number to be added
	 * */
	public void insert(int value){
		theArray[count] = value;     //insert the value
		count++;                     //increment size
	}
	
	/**
	 * Returns a number to represent the size of the array
	 * @returns a number to represent the size of the array
	 * */
	public int size(){
		return count;
	}
	
	/**
	 * Returns true if the array is empty , false if the array is not empty
	 * */
	public boolean isEmpty(){
		return (count == 0);
	}
	
	/**
	 * Displays array contents
	 * */
	public void diplay(){
		System.out.println("A=");
		for(int i = 0; i < count; i++)
			System.out.println(theArray[i] + " ");  //display it
		System.out.println(" ");
	}  
	
	/**
	 * Resort the array in order;
	 * */
	public void recQuickSort(int left, int right){
		if(right <= left)
			return;
		else{
			int pivot = theArray[right];
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition -1);
			recQuickSort(partition +1, right);
		}
	}
	
	/**
	 * Partition the array;
	 * */
	public int partitionIt(int left, int right, int pivot){
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
	 * Exchange the position of the two value
	 * */
	private void swap(int leftPtr, int rightPtr) {
		int temp = theArray[leftPtr];
		theArray[leftPtr] = theArray[rightPtr];
		theArray[rightPtr] = temp;
	}
	
	/**
	 *Returns a string to represents the array
	 *@returns a string to represents the array
	 * */
	public String toString(){
		String result = "{";
		for (int i = 0; i < size(); i++) {
			if (i < size() -1) 
				result += theArray[i] + ",";
			else 
				result += theArray[i];
		}
		result += "}";
		return result;
	}
}
































