package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import impl.LinkedList;
import model.Sort;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		int [] array = { 7,4,3};
//		Sort.mergeSort(array, 0, array.length-1);
//		for(int i=0; i< array.length; i++){
//			System.out.println(array[i]);
//		}
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

























