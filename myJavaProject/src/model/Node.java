package model;

import dataStruct.exception.ElemenNotFoundException;

public class Node {
	protected int data;
	private Node leftChild;
	private Node rightChild;
	
	/*
	 * 
	 * Create a new tree node with the specified data
	 * 
	 * @param obj the element that will become a part of the new tree node*/
	public Node(int element){
		data = element;
		setLeftChild(null);
		setRightChild(null);
	}
	
	/*
	 * Create a new tree node with the specified data
	 * 
	 * @param obj the element that will become a part of the new tree node
	 * @param left the tree left will be the left subtree of this node
	 * @param right the tree right will be the right subtree of this nod
	 * */
	public Node(int element, Node left, Node right){
		data = element;
		
		if(left == null)
			setLeftChild(null);
		else
			setLeftChild(left);
		if(right == null)
			setRightChild(null);
		else
			setRightChild(right);
	}

	/**
	 * Sets the value of the data;
	 * */
//	public void setData(int element){
//		data = element;
//	}
	
	/**
	 *Returns the data of the node
	 *@returns Integer data of the node 
	 * */
	public int getData(){
		return data;
	}
	
	/*
	 * Returns the number of non-null children of this node
	 * @return the integer number of non-null children of this node
	 * */
	public int numChildren(){
		int children = 0;
		if(leftChild != null)
			children = 1 + leftChild.numChildren();
		
		if(rightChild != null)
			children = children +1 + rightChild.numChildren();
		return children;
	}
	
	/**
	 * Gets the leftChild of the node
	 * @returns Node leftChild of the root
	 * */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * Set the leftChild of the node
	 * @param Node the leftChild to be settled
	 * */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Gets the rightChild of the node
	 * @returns Node rightChild of the root
	 * */
	public Node getRightChild() {
		return rightChild;
	}

	/**
	 * Set the rightChild of the node
	 * @param Node the rightChild to be settled
	 * */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	
	/*
	 * Returns a reference to the specified target element if it is found 
	 * in the binary tree. Throws a NoSuchElementException if the specified target element if not found in the binary tree
	 * 
	 * @param targetElement the element being sought in this tree
	 * @return a reference to the specified target
	 * @throws ElementNOtFoundException if an element not found exception occurs
	 * */
	public int findData(int targetData, Node root) throws ElemenNotFoundException{
		Node current = findAgain(targetData, root);
		if(current == null)
			throw new ElemenNotFoundException("Binary tree");
		return (current.data);
	}
	
	/*
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree
	 * @param targetElement the element being sought in this tree
	 * @param next the element to begin searching from 
	 * */
	private Node findAgain(int targetElement, Node next){
		if(next == null)
			return  null;
		if(targetElement == next.data)
			return next;
		Node temp = findAgain(targetElement, next.leftChild);
		if(temp == null)
			temp = findAgain(targetElement, next.rightChild);
		return temp;
	}
	
}






































