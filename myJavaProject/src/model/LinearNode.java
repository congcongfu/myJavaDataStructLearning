package model;

public class LinearNode<T> {
	private LinearNode<T> next;
	private T element;
	
	/*Create a new empty node
	 * */
	public LinearNode(){
		next = null;
		element = null;
	}
	
	/*
	 * Create a node storing the specified element.
	 * @param elem element to be stored
	 * */
	public LinearNode(T elem){
		next = null;
		element = elem;
	}
	
	/*
	 * Returns the node that follows this node.
	 * @return LinearNode<T> reference to the next node;
	 * */
	public LinearNode<T> getNext(){
		return next;
	}
	
	/*Sets the node that follows this one
	 *@param node node to follow this one 
	 * */
	public void setNext(LinearNode<T> node){
		next = node;
	}
	
	/*
	 * Returns element stored in this node.
	 * @return T element stored at this node;
	 * */
	public T getElement(){
		return element;
	}
	
	/*
	 * Sets the element stored in this node.
	 * @param elem element to be stored at this node
	 * */
	public void setElement (T elem){
		element = elem;
	}
	
	// Sets the data stored in this node.
	public String toString (){
		return element.toString();
	}	
}























