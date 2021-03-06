package impl;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import dataStruct.exception.ElemenNotFoundException;
import dataStruct.exception.NonComparableElementException;
import interfaces.ListADT;

public  class ArrayList<T> implements ListADT<T>, Iterable<T> {
	
	private  static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;
	
	protected int rear;
	protected T[] list;
	protected int modCount;
	
	/*Creates an empty list using the default capacity*/
	public ArrayList() {
		
		this(DEFAULT_CAPACITY);
	}
	
	/*
	 * Creates an empty list using the specified capacity
	 * @param initialCapacity the integer value of the size of the array list
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity){
		rear = 0;
		list = (T[]) (new Object[initialCapacity]);
		modCount = 0;
	}
	
	/*
	 * Expand the capacity of the list twice
	 * */
	@SuppressWarnings("unchecked")
	private void expandCapacity(){
		list = (T[]) (new Object[DEFAULT_CAPACITY * 2]);
		rear = modCount -1;
		DEFAULT_CAPACITY *=2;
	}

	/*
	 * Adds the specified Comparable element to this list 
	 * keeping the element in sorted order
	 * @param element the element to be added to the list
	 * */
	public void add(T element){
		if (!(element instanceof Comparable)) 
			throw new NonComparableElementException("OrderedList");
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>) element;
		
		if( size() == list.length)
			expandCapacity();
		
		int scan = 0;
		/*find the insertion location*/
		while (scan < rear && comparableElement.compareTo(list[scan]) > 0) 
			scan++;	
		
		/*shift existing elements up one*/
		for(int shift = rear; shift > scan; shift--)
			list[shift] = list[shift -1];
		
		/*insert element*/
		list[scan] = element;
		rear++;
		modCount++;
	
	}
	/*
	 * Remove the first element of the list
	 * @returns the first element of the list
	 * */
	@Override
	public T removeFirst() {
		if(!isEmpty()){
			T first = list[0];
			T result = remove(first);
			return result;
		}else{
			return null;
		}
	}

	/*
	 * Remove the last element of the list
	 * @returns the last element of the list
	 * */
	@Override
	public T removeLast() {
		if(!isEmpty()){
			T last = list[rear -1];
			T result = remove(last);
			return result;
		}else{
			return null;
		}
	}

	/*
	 * Removes all the specified elements in the list
	 * @param element the element to be removed from the list
	 * @return the remove list elements 
	 * */
	public String removes(T element){
		String result = "";
		while (contains(element)) { 
			T findElement = remove(element);
			result += findElement.toString() + " ";
		}
		
		return result;
	}
	
	
	/*
	 * Removes one element and returns the specified element.
	 * @param element the element to be removed and returned from the list
	 * @return the remove element
	 * @throws ELementNotFoundException if the element is not in the list
	 * */
	public  T remove(T element) throws ElemenNotFoundException{
		T result = null ;
		int index = find(element);
		
		if(index == NOT_FOUND){
			throw new ElemenNotFoundException("Arraylist");
		}
		result = list[index];
		rear--;
		
		/*shift the appropriate elements*/
		for (int scan = index ; scan < rear; scan++){
			list[scan] = list[scan +1];
		}
		list[rear] = null;
		modCount--;
		
		return result;
	}

	/*
	 * Returns the first element of list
	 * @return the first element of list
	 * */
	@Override
	public T first() {
		if(!isEmpty()){
			T first = list[0];
			return first;
		}else {
			return null;
		}
	}

	/*
	 * Returns the last element of list
	 * @return the last element of list
	 * */
	@Override
	public T last() {
		if(!isEmpty()){
			T last = list[rear -1];
			return last;
		}else {
			return null;
		}
	}
	
	/*
	 * Return true if this list contains the specified element,
	 * @param target the target element
	 * @return true if the target is in the list, false otherwise
	 * */
	@Override
	public boolean contains(T target) {
		return (find(target) != NOT_FOUND);
	}

	/*Return true if the list contains no elements
	 * */
	@Override
	public boolean isEmpty() {
		
		return (modCount == 0);
	}

	@Override
	public int size() {
		
		return modCount;
	}

	@Override
	public Iterator<T> iterator() {
		
		return null;
	}
	
	/*
	 * Returns the array index of the specified element,
	 * or the constant NOT_FOUND if it not found
	 * @param target the target element
	 * @return the index of the target element, 
	 * or the NOT_FOUND constant
	 * */
	private int find(T target){
		int scan = 0;
		int result = NOT_FOUND;
		if(!isEmpty()){
			while (result == NOT_FOUND && scan < rear) {
				if(target.equals(list[scan])){
					result = scan;
				}else {
					scan++;
				}
			}
		}
		return result;
	}
	
	/*
	 * Returns a string to representation the list
	 * @return a string to representation the list
	 * */
	public String toString(){
		String result = "[";
		for(int i = 0; i < size() ; i++){
			result += list[i].toString();
			if(i < size() -1){
				result += ",";
			}
		}
		result += "]";
		return result;
	}

	/*
	 * ArrayListIterator iterator over the elements of an ArrayList
	 * */
	@SuppressWarnings({ "unused", "rawtypes" })
	private class ArrayListIterator implements Iterable{

		int iteratorModCount;
		int current;
		
		/*
		 * Set up this iterator using the specified modCount
		 * 
		 * @param modCount the current modification count for the ArrayList
		 * */
		public ArrayListIterator() {
			iteratorModCount = modCount;
			current = 0;
		}

		
		/*
		 * Returns true if the iterator has at least one more element
		 * to deliver in the iteration
		 * @return true if this iteration has at least one more element to deliver
		 * in the iteration
		 * @throws ConcurrentModificationException if the collection has changed
		 * while the iterator is in use.
		 * */
		public boolean hasNext() throws ConcurrentModificationException{
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			return (current < rear);
		}
		
		/*Returns the next element in the iteration. If there are no
		 * more elements in the iteration, a NoSuchElementException is thrown
		 * 
		 * @return  the next element in the iteration
		 * @throws NoSuchElementException if an element not found exception occurs
		 * @throws ConcurrentModificationException if the collection has changed
		 * */
		public T next() throws ConcurrentModificationException{
			if(!hasNext())
				throw new ConcurrentModificationException();
			current++;
			return list[current - 1];
		}
		
		/*
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 * */
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}




















