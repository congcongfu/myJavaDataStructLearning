package model;


import java.awt.Robot;
import java.util.Iterator;

import dataStruct.exception.ElemenNotFoundException;
import impl.LinkedBinaryTree;

/*
 * BinaryTreeNode represents a node in a binary tree with a left and right child
 * */
public class BinaryTreeNode<T> {
	protected T element;
	protected BinaryTreeNode<T> right, left;
	
	/*
	 * 
	 * Create a new tree node with the specified data
	 * 
	 * @param obj the element that will become a part of the new tree node*/
	public BinaryTreeNode(T obj){
		element = obj;
		
		left = null;
		right = null;
	}
	
	/*
	 * Create a new tree node with the specified data
	 * 
	 * @param obj the element that will become a part of the new tree node
	 * @param left the tree left will be the left subtree of this node
	 * @param right the tree right will be the right subtree of this nod
	 * */
	public BinaryTreeNode(T obj, LinkedBinaryTree<T> left,
							LinkedBinaryTree<T> right){
		element = obj;
		if(left == null)
			this.left = null;
		else 
			this.left = left.getRootNode();
		
		if(right == null)
			this.right = null;
		else 
			this.right = right.getRootNode();
	}
	
	/*
	 * Returns the number of non-null children of this node
	 * @return the integer number of non-null children of this node
	 * */
	public int numChildren(){
		int children = 0;
		if(left != null)
			children = 1 + left.numChildren();
		
		if(right != null)
			children = children +1 + right.numChildren();
		return children;
	}
	
	/*
	 * Returns the element at this node
	 * @return the element stored at this node
	 * */
	public T getElement(){
		return element;
	}
	
	/*
	 * Returns the right children of this node
	 * @return the right children of this node
	 * */
	public BinaryTreeNode<T> getRight(){
		return right;
	}
	
	/*
	 * Set the right children of this node
	 * @param node the right child of this  node
	 * */
	public void setRight(BinaryTreeNode<T> node){
		right = node;
	}
	
	/*
	 * Returns the left children of this node
	 * return the left children of this node
	 * */
	public BinaryTreeNode<T> getLeft(){
		return left;
	}
	
	/*
	 * Sets the right child of this nod
	 * @param node the left child of this node
	 * */
	public void setLeft(BinaryTreeNode<T>  node){
		left = node;
	}
	
	/*
	 * Returns a reference to the specified target element if it is found 
	 * in the binary tree. Throws a NoSuchElementException if the specified target element if not found in the binary tree
	 * 
	 * @param targetElement the element being sought in this tree
	 * @return a reference to the specified target
	 * @throws ElementNOtFoundException if an element not found exception occurs
	 * */
	public T find(T targetElement, BinaryTreeNode<T> root) throws ElemenNotFoundException{
		BinaryTreeNode<T> current = findAgain(targetElement, root);
		if(current == null)
			throw new ElemenNotFoundException("Binary tree");
		return (current.element);
	}
	
	/*
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree
	 * @param targetElement the element being sought in this tree
	 * @param next the element to begin searching from 
	 * */
	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next){
		
		if(next == null)
			return null;
		if(next.element.equals(targetElement))
			return next;
		
		BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
		if(temp == null)
			temp = findAgain(targetElement, next.right);
		return temp;
		
	}
	
	
}














