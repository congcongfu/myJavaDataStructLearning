package interfaces;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {
	
	/*
	 * Removes and returns the first element from this list
	 * @return the first element from this list
	 * */
	public T removeFirst();
	
	/*
	 * Removes and returns the last element from this list
	 * @return the last element from this list
	 * */
	public T removeLast();
	
	/*
	 * Remove and return the specified element from the list
	 * @return a reference to the first element in this list
	 * */
	public T remove(T element);
	
	/*
	 * Returns a reference to the first element in this list
	 * @return a reference to the first element in this list
	 * */
	public T first();
	
	/*
	 * Returns a reference to the last element in this list
	 * @return a reference to the last element in this list
	 * */
	public T last();
	
	/*
	 * Returns true if this list contains the specified target element
	 * 
	 * @param target the target that is being sought in the list
	 * @return true if the list contains this element
	 * */
	public boolean contains(T element);
	
	/*
	 * Return true if the list isEmpty
	 * @return true if the list contains no elements
	 * */
	public boolean isEmpty();
	
	/*
	 * Returns the number of elements in this list
	 * @return the integer representation of number of elements in this list
	 * */
	public int size();
	
	/*
	 * Return an iterator for element in this list
	 * @return an iterator over the elements in this list
	 * */
	public Iterator<T> iterator();
	
	/*
	 * Returns a String representation of this list
	 * @return a string representation of this list
	 * */
	public String toString();
	
}


























