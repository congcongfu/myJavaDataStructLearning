package model;

import java.util.LinkedList;
import java.util.Queue;

public class Codes {
	/*
	 * Encode and decode a message using a key of values stored in a aueue.
	 * */
	public static void main(String[] args){
		int [] key = { 5, 12, -3, 8, -9, 4, 10 };
		Integer keyValue;
		String encode = "", decode = "";
		String message = "All programners are playwrights and all" +
						"computers are lousy actors.";
		Queue<Integer> encodingQueue = new LinkedList<Integer>();
		Queue<Integer> decodingQueue = new LinkedList<Integer>();
		
		
		/* load key value*/
		for (int scan = 0; scan < key.length; scan++){
			encodingQueue.add(key[scan]);
			decodingQueue.add(key[scan]);
		}
		System.out.println(encodingQueue);
		System.out.println(decodingQueue);
		
		/* encode message*/
		
		for (int scan = 0; scan < key.length; scan++){
			keyValue = encodingQueue.remove();
			encode += (char) message.charAt(scan) + keyValue;
			encodingQueue.add(keyValue);
		}
		
		System.out.println("Encoded Message:\n" +encode+ "\n");
		
		/*delete message*/
		for(int scan = 0; scan < key.length; scan++){
			keyValue = decodingQueue.remove();
			decode += (char) message.charAt(scan) - keyValue;
			decodingQueue.add(keyValue);
		}
		System.out.println("Decoded Message:\n" +decode);
}
	
}







