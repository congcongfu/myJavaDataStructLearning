package test;

import java.awt.image.RescaleOp;
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
    	}
	
	public static void createFile(){
		File file = new File("E:/Eclipse/test.txt");
		try{
			if(!file.exists()){
				file.createNewFile();
				file.mkdirs();
			}
			System.out.println("该分区大小"+file.getTotalSpace()/(1024*1024*1024)+"G");
			System.out.println("文件名  "+file.getName());
			System.out.println("文件父目录字符串  "+file.getParent());
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	


	
}

























































