package model;


/**
 * @author cong.fu @2016/03/20
 * */

public class PriorityQueue {

	private final int SIZE = 20;
	private Edge[] queueArray;
	private int count;
	
	/**
	 * Create a new PriorityQueue
	 * */
	public PriorityQueue(){
		queueArray = new Edge[SIZE];
		count = 0;
	}
	
	/**
	 * Insert item into the queue
	 * @param item to be inserted into the queue
	 * */
	public void insert(Edge item){
		int i;
		for(i = 0; i < count; i++)
			if(item.distance >= queueArray[i].distance)
				break;
		for (int k = count -1; k >= i; k--)
			queueArray[k+1] = queueArray[k];            
		queueArray[i] = item;
		count++;
	}
	
	public boolean isEmpty(){
		return (count == 0);
	}
	
	/**
	 * Removes the minimum item in the queue
	 * @returns the minimum item in the queue
	 * */
	public Edge removeMin(){
		return queueArray[--count];
	}
	
	/**
	 * Remove the item in the index of the queue
	 * @param the index of the item to be remove
	 * */
	public void remove(int index){
		for(int i = index; i < count -1; i++)
			queueArray[i] = queueArray[i+1];
		count--;
	}
	
	/**
	 * peek at item index
	 * */
	public Edge peek(int index){
		return queueArray[index];
	}
	
	/**
	 * Finds the item with specified  value
	 * @param value to be find 
	 * @returns  the index of the specified item in the queue 
	 * */
	public int find(int value){
		for(int i = 0; i < count; i++)
			if(queueArray[i].endVert == value)
				return i;
		return -1;
	}
}

























