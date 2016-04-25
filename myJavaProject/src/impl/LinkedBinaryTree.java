package impl;

import java.util.Iterator;

import interfaces.BinaryTreeADT;
import model.BinaryTreeNode;
/*LinkedBinaryTree implements BinaryTreeADT<T>
 * */

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> , Iterable<T>{
	protected BinaryTreeNode<T> root;
	protected int modCount;
	
	/*
	 * Create an empty binary tree
	 * */
	 public LinkedBinaryTree() {
		 root = null;
	}
	 
	 /*
	  * Create a binary tree with the specified element as its root
	  * @param element the element that will become the root of the binary tree
	  * */
	 public LinkedBinaryTree(T element){
		 root = new BinaryTreeNode<T>(element);
	 }
	 
	 /*
	  * Creates a binary tree with the specified element as its root and the
	  * given trees as its left child and right child
	  * 
	  * @param left the left subtree of this tree
	  * @param right the right subtree of this tree
	  * */
	 public LinkedBinaryTree(T element, LinkedBinaryTree<T> left,
			 		LinkedBinaryTree<T> right){
		 root = new BinaryTreeNode<T>(element);
		 root.setLeft(left.root);
		 root.setRight(right.root);
	 }

	@Override
	public T getRootElements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Returns the node of the tree
	 * */
	public BinaryTreeNode<T> getRootNode(){
		return root;
	}

	/*
	 *Returns true if the tree contains no elements
	 *@return true if the tree contains no elements
	 * */
	@Override
	public boolean isEmpty() {
		modCount = root.numChildren();
		return (modCount == 0);
	}

	/*
	 * Returns a number represents the size of the tree
	 * @return a number represents the size of the tree
	 * */
	@Override
	public int size() {
		modCount = root.numChildren();
		return modCount;
	}

	/*
	 * Returns true if the node of the tree contains the specified elements
	 * @return true if the node of the tree contains the specified elements
	 * */
	@Override
	public boolean contains(T targetElement) {
		
		return findAgain(targetElement, root);
	}
	
	/*
	 * Returns a reference to the specified target element if it is
	 * found in this node of tree
	 * @param targetElement the element being sought in this tree
	 * */
	private boolean findAgain(T targetElement, BinaryTreeNode<T> root){
		if(root == null)
			return false;
		if(root.getElement() == targetElement)
			return true;
		return findAgain(targetElement, root.getLeft()) || findAgain(targetElement, root.getRight());
	}

	/*
	 * Returns true if the node of the tree contains the specified elements
	 * @returns true if the tree contains the specified elements
	 * */
	@Override
	public T find(T targetElement) {
		if(contains(targetElement))
		              return targetElement;
		else 
			return null;
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}


}
