package impl;

import java.util.Iterator;

import dataStruct.exception.ElemenNotFoundException;
import interfaces.ListADT;
import interfaces.UnorderedListADT;

public class UnorderedList<T> implements UnorderedListADT<T>, Iterable<T> {

	private  static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;
	
	protected int rear;
	protected T[] list;
	protected int modCount;
	
	/*Creates an empty list using the default capacity*/
	public UnorderedList() {
		
		this(DEFAULT_CAPACITY);
	}
	
	/*
	 * Creates an empty list using the specified capacity
	 * @param initialCapacity the integer value of the size of the array list
	 * */
	public UnorderedList(int initialCapacity){
		rear = 0;
		list = (T[]) (new Object[initialCapacity]);
		modCount = 0;
	}
	
	/*
	 * Expand the capacity of the list twice
	 * */
	private void expandCapacity(){
		list = (T[]) (new Object[DEFAULT_CAPACITY * 2]);
		rear = modCount -1;
		DEFAULT_CAPACITY *=2;
	}
	
	/*
	 * Adds the specified element to this list 
	 * 
	 * @param element the element to be added to the list
	 * */
	public void add(T element){
		
		if( size() == list.length)
			expandCapacity();
		list[rear] = element;
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
			result += result.toString() + " ";
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
		// TODO Auto-generated method stub
		return modCount;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	 * Adds the specified element to the front of the list
	 * @param element the element to the front of the list 
	 * */
	@Override
	public void addToFront(T element) {
		if(!isEmpty()){
			if(size() == list.length)
				expandCapacity();
							
			/*shift element up one */
			for(int i = rear ; i > 0; i--){
				list[i] = list[i -1];
			}
			/*insert element*/
			list[0] = element;
			rear++;
			modCount++;
		}else {
			add(element);
		}
		
		
	}

	/*
	 * Adds the specified element to the rear of the list
	 * @param element the element to the front of the list 
	 * */
	@Override
	public void addToRear(T element) {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			if(size() == list.length)
				expandCapacity();
			/*insert element*/
			list[rear] = element;
			rear++;
			modCount++;
		}else {
			add(element);
		}
		
	}

	/*
	 * Adds the specified element after the specified target element
	 * Throws an ElementNotFoundException if the target is not found
	 * @param element the element to be added after the target element
	 * @param target the target that the element is to be added after
	 * */
	@Override
	public void addAfter(T element, T target) {
		
		if(size() == list.length)
			expandCapacity();
		int scan = 0;
		
		/*find the insertion point*/
		while (scan < rear && !target.equals(list[scan]))
			scan++;
		if(scan == rear)
			throw new ElemenNotFoundException("UnorderedList");
		scan++;
		
		/*shift element up one */
		for(int shift = rear; shift > scan; shift--){
			list[shift] = list[shift -1];
		}
		
		/*insert element*/
		list[scan] = element;
		rear++;
		modCount++;
		
	}

}























