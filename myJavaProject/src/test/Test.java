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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import javax.management.Query;



public class Test {
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	static final int MAXIMUM_CAPACITY = 1 << 30;
	public static void main(String[] args) throws InterruptedException {
		long patience = 1000 * 60 * 60;
		Vector<E>
//		if(args.length >0){
//			try{
//				patience = Long.parseLong(args[0]) * 1000;
//			}catch(NumberFormatException e){
//				System.out.println("Argeument must be an Integer");
//				System.exit(1);
//				System.gc();
//			}
//		}
//		threadMessage("Starting MessageLoop thread");
//		long startTime = System.currentTimeMillis();
//		Thread thread = new Thread(new MessageLoop(),"fuck hard");
//		thread.start();
//		
//		while (thread.isAlive()) {
//			threadMessage("Still waiting...");
//			
//			thread.join(1000);
//			if((System.currentTimeMillis() - startTime) > patience && thread.isAlive()){
//				threadMessage("Tired of wating!");
//				thread.interrupt();
//				thread.join();
//			}
//		}
//		threadMessage("Finally!");
		
		
//		int [] array = { 7,4,3};
//		Sort.mergeSort(array, 0, array.length-1);
//		for(int i=0; i< array.length; i++){
//			System.out.println(array[i]);
//		}
	}
	
	public static int jie(int i){
		if (i > 0) {
			return i * jie(i -1);
		}else{
			return 1;
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
	
	static void threadMessage(String message){
		String threadName = Thread.currentThread().getName();
		
		System.out.printf("%s: %s%n",threadName, message);
	}
	
	private static class MessageLoop  implements Runnable{

		@Override
		public void run() {
			String imprtantInfo[] = {
					"Fuck Thread",
					"Fuck Java",
					"Fuck DataStruct",
					"Fuck JVM"
			};
			try{
				for(int i = 0; i < imprtantInfo.length; i++){
					Thread.sleep(4000);
					threadMessage(imprtantInfo[i]);
				}
			}catch(InterruptedException e){
				threadMessage("I wasn't done!");
			}
		}
		
	}
}

























