package model;

import java.security.acl.LastOwnerException;

import org.omg.CORBA.portable.ValueOutputStream;
import org.w3c.dom.events.MutationEvent;

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
	
	/*
	 * Recursively sorts a range of objects in the specified array using the merge sort algorithm.
	 * 
	 * @param data the array to be sorted
	 * @param min the index of the first element
	 * @param max the index of the last element
	 * */
	private static <T extends Comparable<T>>
			void mergeSort(T[] data, int min, int max){
		if(min < max){
			int mid  = (min + max) / 2;
			System.out.println("mid1= "+mid);
			mergeSort(data, min, mid);
			System.out.println("mid2= "+mid);
			mergeSort(data, mid+1, max);
			System.out.println("mid3= "+mid);
			merge(data, min, mid, max);
		}
	}
	
	/*
	 * Merges two sorted subarrays of the specified array.
	 * @param data the array to be sorted
	 * @param fisrt the beginning index of the first subarray
	 * @param mid the ending index of the first subarray
	 * @param last the ending index of the last subarray
	 * */
	private static<T extends Comparable<T>>
			void merge(T[] data, int first, int mid, int last){
		T[] temp = (T[]) (new Comparable[data.length]);
		
		int first1 = first, last1 = mid; //endpoints of first subarray
		int first2 = mid+1, last2 = last;  //endpoints of second subarray
		int index = first1;  //next index open in temp array
		
		//Copy smaller item from each subarray into temp until one of the subarrays is exhausted
		while(first <= last1 && first2 <= last2){
			if(data[first1].compareTo(data[first2]) < 0){
				temp[index] = data[first];
				first1++;
			}else{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//Copy remaining elements from first subarray, if any 
		while(first1 <= last1){
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//Copy remaining elements from second subarray, if any
		while(first2 <= last2){
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//Copy merged data into original array
		for(index = first; index <= last; index++)
			data[index] = data[index];
		
	}
	
	
	/*
	 * Recursively sorts a range of objects in the specified number using the merge sort algorithm.
	 * 
	 * @param number the array to be sorted
	 * @param min the index of the first element
	 * @param max the index of the last element
	 * */
	public static void mergeSort(int[] data, int min, int max){
		if(min < max){
			
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}
	
	
	/*
	 * Merges two sorted subarrays of the specified array.
	 * @param int[] the array to be sorted
	 * @param fisrt the beginning index of the first subarray
	 * @param mid the ending index of the first subarray
	 * @param last the ending index of the last subarray
	 * */
	private static void merge(int[] data, int first, int mid, int last){
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
		System.out.println();
		System.out.println("first = "+first);
		System.out.println("mid = "+mid);
		System.out.println("last = "+last);
		int[] temp = (int []) new int[data.length];
		int first1 = first, last1 = mid; //endpoints of first subarray
		int first2 = mid+1, last2 = last;  //endpoints of second subarray
		int index = first1;  //next index open in temp array
		
		//Copy smaller item from each subarray into temp until one of the subarrays is exhausted
		while(first1 <= last1 && first2 <= last2){
			if(data[first1] < data[first2]){
				temp[index] = data[first1];
				first1++;
			}else{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//Copy remaining elements from first subarray, if any 
		while(first1 <= last1){
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//Copy remaining elements from second subarray, if any
		while(first2 <= last2){
			System.out.println("first2="+first2);
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//Copy merged data into original array
		for(index = first; index <= last; index++)
			data[index] = temp[index];
	}

}



























