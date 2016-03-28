package impl;

import java.util.Arrays;

import dataStruct.exception.EmptyCollectionException;
import interfaces.QueueADT;


/*
 * CircularArrayQueue represents an array implementation of a queue in
 * which the indexes for the front and rear of the queue circle back to
 * when they reach the end of array.
 * */
public class CircularArrayQueue<T> implements QueueADT<T> {
	private final static  int DEFAULT_CAPACITY = 100;
	private int front, rear , count;
	private T[] queue;

	/*
	 * Create an empty queue using the specified capacity.
	 * @param initialCapacity the initial size of the circle
	 * */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity) {
		front = rear = count = 0;
		queue = ((T[]) new Object[initialCapacity]);
	}
	
	/*
	 * Create an element queue using the default capacity.
	 * */
	public CircularArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/*
	 * Adds the specified element to the rear of this queue, expanding
	 * the capacity of the queue array if necessary.
	 * @param element the element to add to the rear of the queue;
	 * */
	@Override
	public void enqueue(T element) {
		if (size() == queue.length)
			expandCapacity();
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	/*
	 * Removes the element at the front of the queue and return a
	 * reference to it, new a T[] to replace the old queue;
	 * @return the element removed from the front of the queue;
	 * @throw an EmptyCollectionException if the queue is empty;
	 * */
	@Override
	public T dequeue() throws EmptyCollectionException{
		if (isEmpty()) {
			throw new EmptyCollectionException("Queue is Empty!");
		}
		T result = queue[front];
		System.out.println("result = "+result);
		System.out.println("rear = "+rear);
//		queue[rear] = null;            //there will be a problem when you us the function the second time;
		
		front = (front +1) % queue.length;
		count--;
		T[] newQueue = (T[]) (new Object[count]);
		for(int i = 0; i < count; i++){
			newQueue[i] = queue[i];
		}
		queue = newQueue;
		return result;
	}
	
	/*
	 * Returns the first element of the queue
	 * @throw an EmptyCollection if the queue is empty;
	 * */
	@Override
	public T first() throws EmptyCollectionException{
		if (isEmpty()) {
			throw new EmptyCollectionException("Queue is empty!");
		}else {
			T first = queue[0];
			return first;
		}
	}
	
	/*
	 * Create a new array to store the contents of this queue with
	 * twice the capacity of the old one
	 * */
	private void expandCapacity(){
		T[] expandor = (T[])(new Object[queue.length * 2]);
		for (int scan = 0; scan < count; scan++){
			expandor[scan] = queue[front];
			front = (front +1 ) % queue.length;
		}
		front = 0;
		rear = count;
		queue = expandor;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	/*
	 * Returns a String to representation the queue
	 * return a string to representation the queue
	 * */
	public String toString() {
		String result = "[";
		for(int i = 0; i < size(); i++){
			result += queue[i];
			if(i < size() -1){
				result += ",";
			}
		}
		result += "]";
		return result;
	}

}
