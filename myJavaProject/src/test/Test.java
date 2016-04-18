package test;

import impl.LinkedList;
import model.Sort;

public class Test {

	public static void main(String[] args) {
		
		int [] array = { 7,4,3};
		Sort.mergeSort(array, 0, array.length-1);
		for(int i=0; i< array.length; i++){
			System.out.println(array[i]);
		}
		
		
	}
	public static int sum(int num){
		int result;
		if(num == 1)
			result = 1;
		else 
			result = num * sum(num -1);
		return result;
		
	}

}
