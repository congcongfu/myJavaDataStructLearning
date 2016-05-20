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

import impl.ArrayHeap;
import impl.ArrayQueue;
import impl.LinkedList;
import model.Sort;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Runnable task = () ->{
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		
		task.run();
		Thread thread = new Thread(task,"fuck hard");
		Thread thread1 = new Thread(task,"really hard");
		thread.start();
		thread1.start();
		System.out.println("Done!");
		
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

























