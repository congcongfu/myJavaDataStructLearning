package impl;

import java.util.Iterator;

import dataStruct.exception.ElemenNotFoundException;
import dataStruct.exception.EmptyCollectionException;
import interfaces.ListADT;
import model.LinearNode;

public  class LinkedList<T> implements ListADT<T>, Iterable<T> {
   
	protected int count;
	protected LinearNode<T> head, tail;
	protected int modCount;
	
	/*Creates an empty list*/
    public LinkedList() {
    	count = 0;
    	head = tail = null;
    	modCount = 0;
	}
    
    /*
     * Adds specified elements to list
     * */
    public void add(T element){
    	// TODO Auto-generated method stub
		LinearNode<T> node = new LinearNode<T>(element);
		
		if(isEmpty()){
			head = node;
		}else {
			tail.setNext(node);
		}
		tail = node;
		count++;
    }
    
    /*
	 * Removes the first element of the list
	 * @return the first element of the list
	 * */
	@Override
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}else {
			remove(head.getElement());
			return head.getElement();
		}
	}

	/*
	 * Removes the last element of the list
	 * @return the last element of the list
	 * */
	@Override
	public T removeLast() {
		if(isEmpty()) {
			return null;
		}else {
			remove(tail.getElement());
			return tail.getElement();
		}
	}

	/*
	 * Removes the first instance of specified element from this 
	 * list and returns a reference to it. Throws an EmptyCollectionException
	 * if the list is empty. Throws a ElementNotFoundException if the
	 * specified element is not found in the list.
	 * 
	 * @param targetElement the element to be remove from the list
	 * @return a reference to the remove element
	 * @throws EmptyCollectionException if the list is empty
	 * @throws ElementNotFoundException if the target element is not found
	 * */
	@Override
	public T remove(T element) throws EmptyCollectionException,ElemenNotFoundException{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedList");
		
		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while (current != null && !found){
			if(element.equals(current.getElement())){
				found = true;
			}else{
				previous = current;
				current = current.getNext();
			}
				
		}
		
		if(!found){
			throw new ElemenNotFoundException("LinkedList");
		}
		if(size() == 1) {
			//only one element in the list
			head = tail = null;
		}else if(current.equals(head)){
			head = current.getNext();
		}else if(current.equals(tail)){
			tail = previous;
			tail.setNext(null);
		}else {
			//target is in the middle
			previous.setNext(current.getNext());
		}
		count--;
		modCount++;
		return current.getElement();
	}

	/*
	 * Return the first element of the list
	 * */
	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()){
			throw new EmptyCollectionException("queue is empty");
		}
		return head.getElement();
	}

	/*
	 * Return the first element of the list
	 * */
	@Override
	public T last() {
		if (isEmpty()){
			throw new EmptyCollectionException("queue is empty");
		}
		return tail.getElement();
	}
	
	/*
	 * Returns true if the list contains the element
	 * @param element the element to the list
	 * */
	@Override
	public boolean contains(T element) {
		boolean result = false;
		if(isEmpty()){
			result =  false;
		}else{
			LinearNode<T> current = head;
			while (current != null) {
				if(element == current.getElement()) result = true;
				current = current.getNext();
				
			}
		}
		return result;
	}

	/*
	 * Returns true if the list contains no elements
	 * @returns Boolean
	 * */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	/*
	 * Returns a string to representation the list
	 * @returns a string
	 * */
	public String toString(){
		String result = "[";
		LinearNode<T> current = head;
		while (current != null) {
			result += current.toString();
			current = current.getNext();
			if (current != null) {
				result += ",";
			}
		}
		result += "]";
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
