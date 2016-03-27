package interfaces;

public interface QueueADT<T> {
	
	/*Adds one elements to the rear of this queue.
	 * @param element the element to be added to the rear of the queue
	 * */
	public void enqueue(T element);
	
	/*Remove and return the element at the front of this queue.
	 * @return the element at the front of the queue*/
	public T dequeue();
	
	/*Returns without removing the element at the front of this queue.
	 * @return the first element of the queue*/
	public T first();
	
	/*Returns true if the queue contains no elements
	 * @return true if the queue is empty
	 * */
	public Boolean isEmpty();
	
	/*
	 * Returns the numbers of the elements in the queue.
	 * @return the integer representation of the size of the queue
	 * */
	public int size();
	
	/*
	 * Returns a string representation of the queue.
	 * @return the string representation of the queue.
	 * */
	public String toString();
	
}
