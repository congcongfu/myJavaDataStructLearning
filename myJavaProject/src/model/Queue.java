package model;

/**
 * Queue 
 * @author cong.fu @2015/05/20
 * */
public class Queue {

	private final int SIZE = 20;
	private int[] queueArray;
	private int front;
	private int rear;
	
	/**
	 * Create a new queue
	 * */
	public Queue(){
		queueArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	/**
	 * Insert a item into the queue
	 * @param item to be inserted
	 * */
	public void insert(int item){
		if(rear == SIZE-1)
			rear = -1;
		queueArray[++rear] = item;
	}
	
	/**
	 * Remove item from front of the queue
	 * @returns item in front of the queue
	 * */
	public int remove(){
		int temp = queueArray[front++];
		if(front == SIZE)
			front = 0;
		return temp;
	}
	
	/**
	 * Returns true if the queue is empty
	 * */
	public boolean isEmpty(){
		return ( rear +1 == front || (front +SIZE-1 == rear));
	}
}























