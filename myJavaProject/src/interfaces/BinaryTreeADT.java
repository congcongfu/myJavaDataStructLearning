package interfaces;

import java.util.Iterator;

/*
 * BinaryTreeADT defines the interface to a binary tree data  structure
 * 
 * */
public interface BinaryTreeADT<T> {
	
	/*
	 * Returns a reference to the root element
	 * 
	 * @return a reference to the root
	 * */
	public T getRootElements();
	
	/***
	 * Returns true if this binary is empty and false otherwise.
	 * 
	 * @return true if this binary is empty, false otherwise.
	 * */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this binary tree
	 * @return the number of elements in the tree
	 * **/
	public int size();
	
	/**
	 * Return tree if the binary tree contain an element that matches
	 * the specified element and false otherwise.
	 * @param targetElement the element being sought in the tree
	 * @return true if the tree contains the target element
	 * **/
	public boolean contains(T targetElement);
	
	
	/***
	 * Returns a reference to the specified element if it is found in this binary tree
	 * 
	 * Throws an Exception if the specified element is not found
	 * Return a reference to the specified element
	 * */
	public T find(T targetElement);
	
	/**
	 * Return the string representation of this binary tree
	 * @return a string representation of the binary tree;
	 * */
	public String toString();
	
	/**
	 * Returns a iterator over the elements of this tree
	 * 
	 * @return a iterator over the elements of this tree
	 * */
	public Iterator<T> iterator();
	
	/***
	 * Returns an iterator that represents an inorder traversal on this
	 * binary tree
	 * 
	 * @return an iterator over the elements of this bianry tree
	 * */
	public Iterator<T> iteratorPreOrder();
	
	/**
	 * Returns an iterator that represents a postorder traversal on this
	 * binary tree
	 * 
	 * @return an iterator over the elements of this binary tree
	 * */
	public Iterator<T> iteratorPostOrder();
	
	/*
	 * Returns an iterator that represents a level order traversal on the binary 
	 * @return an iterator over the elements of this binary  tree
	 * */
	public Iterator<T> iteratorLevelOrder();
	
	
}
























