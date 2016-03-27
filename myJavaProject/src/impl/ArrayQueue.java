package impl;


import java.util.Arrays;

import interfaces.QueueADT;

public class ArrayQueue<T> implements QueueADT<T> {
	private static int DEFAUL_CAPACITY = 100;
	private int count = 0;
	private int front, rear;;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		count = 0; front = 0; rear = 0;
		queue = (T[]) (new Object[DEFAUL_CAPACITY]);
		
	}
	

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity){
		count = 0; front = 0; rear = 0;
		queue = (T[]) (new Object[initialCapacity]);
	}

	/*Insert an element at the rear of the queue.
	 * This method runs in 0(1)time*/
	@Override
	public void enqueue(T element) throws NullPointerException, IllegalStateException{
		if(count == DEFAUL_CAPACITY)
			expand();
		/*copy items*/
		count++;
		queue[rear] = element;
		rear = (rear+1) % DEFAUL_CAPACITY;
		
	}

	/*remove the front element from the queue
	 * This method runs in 0(1) time*/
	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() throws IllegalStateException{
		//if queue is empty, throw IllegalStateException
		if(count == 0)
			throw new IllegalStateException("Queue is empty: underflow");
		else {
			count--;
			T[] newQueue = (T[]) (new Object[count]);;
			for(int i = 0; i < count; i++){
				newQueue[i] = queue[i];
			}
			front = (front + 1) % DEFAUL_CAPACITY;
			return (T) newQueue;
			}
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if(count == 0)
			throw new IllegalStateException("Queue is empty: underflow");
		else {
			return queue[count -1];
			}
	}
	
	/*expand the queue size  by double*/
	private void expand(){
		queue = Arrays.copyOf(queue, queue.length * 2);
		front = 0;
		rear = count -1;
		DEFAUL_CAPACITY *=2;
	}

	@Override
	public Boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}
	
	/*return a string representation of the queue*/
	public String toString(){
		String result = "[";
		for (int i = 0; i < count; i++){
			result += queue[(front + i) % DEFAUL_CAPACITY];
			if (i < count -1) {
				result +=",";
			}
		}
		result +="]";
		return result;
	}

}














