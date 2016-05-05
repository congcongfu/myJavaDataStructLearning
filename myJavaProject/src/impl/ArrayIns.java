package impl;

import org.omg.CORBA.Request;

public class ArrayIns {
	
	private int[] theArray;
	private int count;
	
	/**
	 * Creates a new empty Arrays
	 * */
	public ArrayIns(int max){
		theArray = new int[max];
		count = 0;
	}
	
	/**
	 * Inserts a number into the array
	 * @param the number to be insert into the array
	 * */
	public void insert(int value){
		theArray[count] = value;
		count++;
	}
	
	/**
	 * Returns a string to represents the array
	 * @returns a string to represents the array
	 * */
	public String toString(){
		String result = "{";
		for (int i = 0; i < count; i++) {
			if(i < count -1){
				result += theArray[i] + ",";
			}
			else
				result += theArray[i];
		}
		
		return result + "}";
	}
	
	/**
	 * Sort the array
	 * */
	public void quickSort(){
		recQuickSort(0, count -1);
	}

	/**
	 * Resort the array
	 * @param left position of partition part
	 * @param right position of partition part 
	 * */
	private void recQuickSort(int left, int right) {
		int size = right - left +1;
		if(size <= 3)
			manualSort(left, right);
		else{
			int median = medianof3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition -1);
			recQuickSort(partition +1, right);
		}
	}
	
	private int medianof3(int left, int right) {
		int center = (left+right) / 2;
		
		if(theArray[left] > theArray[center])
			swap(left, center);
		
		if(theArray[left] > theArray[right])
			swap(left, right);
		
		if(theArray[center] > theArray[right])
			swap(right, center);
		swap(center, right -1);
		return theArray[right -1];
	}

	/**
	 * Returns a number to represents the number in the array which is less than the pivot
	 * and reorder the array
	 * @returns Integer 
	 * */
	private int partitionIt(int left, int right, int pivot) {
		int leftPtr = left;
		int rightPtr = right;
		while(true){
			while( theArray[++leftPtr] < pivot);  // find bigger
			
			while( theArray[--rightPtr] > pivot); //find smaller
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right -1);                 //restore pivot
		return leftPtr;							 // return pivot location	
	}

	private void manualSort(int left, int right) {
		int size = right - left +1;
		if(size <= 1)
			return ;  //no sort necessary
		if(size == 2){   // size is 2 left and right
			if(theArray[left] > theArray[right])
				swap(left, left);
			return;
		}else {
			if( theArray[left] > theArray[right - 1])
				swap(left, right -1);
			if( theArray[left] > theArray[right])
				swap(left, right);
			if( theArray[right -1] > theArray[right])
				swap(right - 1, right);
		}
	}
	
	/**
	 * Exchange the two value
	 * */
	private void swap(int left, int center) {
		int temp = theArray[left];
		theArray[left] = theArray[center];
		theArray[center] = temp;
	}
}




















