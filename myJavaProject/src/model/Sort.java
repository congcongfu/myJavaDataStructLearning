package model;

public class Sort {
	
	/*
	 * Swaps to elements in a array . Used by various sorting algorithms.
	 * 
	 * @param data the  array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 * */
	private static <T extends Comparable<? super T>> 
			void swap(T[] data, int index1, int index2){
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	/*
	 * Swap to elements in a array (Integer)
	 * */
	private static void swap(int [] data, int index1, int index2){
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	/*
	 * Sorts the specified array of objects using an insertion
	 * sort algorithm
	 * 
	 * @param data the array to be sorted
	 * */
	public static <T extends Comparable<? super T>>
			void insertionSort (T[] data){
		for(int index = 1; index < data.length; index++){
			T key = data[index];
			int position = index;
			
			/* shift larger value to the right*/
			while  (position > 0 && data[position -1].compareTo(key) > 0){
				data[position] = data[position -1];
				position--;
			}
			data[position] = key;
		}
	}
	
	/*
	 * Sort the numbers in the array using an insertion
	 * sort algorithm
	 * 
	 * @param data the array to be sorted
	 * */
	public static  int[] insertionSort (int[] data){
		for(int index = 1; index < data.length; index++){
			int key = data[index];
			int position = index;
			
			/* shift larger value to the right*/
			while  (position > 0 && (data[position -1] > key)){
				data[position] = data[position -1];
				position--;
			}
			data[position] = key;
		}
		return data;
	}
	
	/*
	 * Sort the specified array of objects using a bubble sort algorithm
	 * 
	 * @param data the array to be sorted
	 * */
	public static <T extends Comparable<? super T>>
			void bubbleSort(T[]  data){
		int position, scan;
		T temp;
		for (position = data.length -1 ; position >= 0; position --){
			for (scan = 0; scan <= position -1; scan++){
				if(data[scan].compareTo(data[scan + 1]) >0)
					swap(data, scan, scan+1);
			}
		}
	}
	
	/*
	 * Sort the number in the array of objects using bubble sort algorithm;
	 * @param data the array the be sorted
	 * */
	public static void bubbleSort(int[] data){
		int position, scan;
		
		for(position = data.length -1; position >= 0; position--){
			for(scan = 0; scan <= position -1; scan++){
				if(data[scan] > data[scan+ 1])
					swap(data, scan, scan+1);
			}
		}
	}
	
	
	/*
	 * Sort the specified array of objects using the quick sort algorithm.
	 * @param data the array to be sorted
	 * */
	public static <T extends Comparable<? super T>>
			void quickSort(T[] data){
		quickSort(data, 0, data.length -1);
	}
	
	/* 
	 * Sort the number of array using the quick sort algorithm
	 * @param data the array to be sorted
	 * */
	public static void quickSort(int[] data){
		quickSort(data, 0, data.length -1);
	}
	
	/*
	 * Recursively sorts a range of objects in the specified array
	 *  using  the quick sort algorithm
	 *  
	 *  @param data the array to be sorted
	 *  @param min the minimum index in the range to be sorted
	 *  @param max the maximum index in the range to be sorted
	 * */
	private static <T extends Comparable<? super T>>
			void quickSort(T[] data, int min , int max){
		if (min < max){
			//create partitions
			int indexofpartition = parition(data, min, max);
			
			//sort the left partition (lower values)
			quickSort(data,min, indexofpartition -1);
			
			// sort the right partition (higher values)
			quickSort(data, indexofpartition +1, max);
		}
	}
	
	/*
	 * Recursively sorts a range of objects in the specified array
	 *  using  the quick sort algorithm
	 *  
	 *  @param number the array to be sorted
	 *  @param min the minimum index in the range to be sorted
	 *  @param max the maximum index in the range to be sorted 
	 * */
	private static void quickSort(int [] data, int min, int max){
		if (min < max){
			//create partitions
			int indexofpartition = parition(data, min, max);
			System.out.println("indexofpartition = "+indexofpartition);
			
			//sort the left partition (lower values)
			quickSort(data,min, indexofpartition -1);
			
			// sort the right partition (higher values)
			quickSort(data, indexofpartition +1, max);
		}
	}
	
	/*
	 * Used by quick sort algorithm to find the partition
	 * 
	 * @param data the array to be sorted
	 * @param min the minimum index in the range to be sorted
	 * @param max the maximum index in the range to be sorted
	 * 
	 * */
	private static <T extends Comparable<? super T>>
	 		int parition(T[] data, int min, int max){
		T partitionelement;
		int left, right;
		
		int middle = (min + max) / 2;
		//Use the middle data value as the partition element 
		partitionelement = data[middle];
		
		//move it out of the way for now
		swap(data, middle, min);
		
		left = min;
		right  = max;
		
		while (left < right){
			//search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) < 0) {
				left++;	
			}
			
			//search for an element that is < partition element
			while( data[right].compareTo(partitionelement) > 0){
				right--;
			}
			//swap the elements
			if(left < right){
				swap(data, left, right);
			}
		}
		return right;
	}
	
	/*
	  * Used by quick sort algorithm to find the partition
	 * 
	 * @param number of the array to be sorted
	 * @param min the minimum index in the range to be sorted
	 * 
	 * */
	private static int parition(int [] data, int min, int max){
		int partitionelement ;
		int left, right;
		
		int middle = (min + max) / 2;
		//Use the middle data value as the partition element 
		partitionelement = data[middle];
		
		//move it out of the way for now
		swap(data, middle, min);
		
		left = min;
		right  = max;
		while (left < right){
			//search for an element that is > the partition element
			while ((data[left] < partitionelement)) {
				left++;	
			}
			
			//search for an element that is < partition element
			while( data[right] > partitionelement){
				right--;
			}
			//swap the elements
			if(left < right){
				 swap(data, left, right);
			}
		}
		return right;
	}

}



























