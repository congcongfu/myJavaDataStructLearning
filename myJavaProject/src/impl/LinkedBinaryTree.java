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
	  * Create a bianry tree with the specified element as its root
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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(T targetElement) {
		// TODO Auto-generated method stub
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
