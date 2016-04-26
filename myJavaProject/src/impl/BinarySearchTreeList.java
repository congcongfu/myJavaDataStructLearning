package impl;

import interfaces.ListADT;
import interfaces.OrderedListADT;

public class BinarySearchTreeList<T> extends LinkedBinarySearchTree<T> 
				implements ListADT<T>, OrderedListADT<T>, Iterable<T>{
	
	/**
	 * Create an empty BinarySearchTreeList
	 * */
	public BinarySearchTreeList() {
		super();
	}
	
	/**
	 * Adds the given element to this list
	 * @param element the element to be added to the list
	 * */

	@Override
	public void add(T element) {
		addElemetn(element);
	}

	/**
	 * Removes and returns the first element from this list.
	 * @return the first element in the list
	 * */
	@Override
	public T removeFirst() {
		return removeMin();
	}
	
	/**
	 * Removes and returns the last element from this list
	 * @return the first element in the list
	 * */
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return removeMax();
	}

	/**
	 * Removes and returns the specified element from this list
	 * @param element the element being sought in the list
	 * @return the element from the list that matches the target
	 * */
	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return removeElement(element);
	}

	/**
	 * Returns a reference to the first element on this list.
	 * @return a reference to the first element in the list
	 * */
	@Override
	public T first() {
		return findMin();
	}

	/**
	 * Returns a reference to the last element on this list
	 * @return a reference to the last element on this list
	 * */
	@Override
	public T last() {
		return findMax();
	}

}
