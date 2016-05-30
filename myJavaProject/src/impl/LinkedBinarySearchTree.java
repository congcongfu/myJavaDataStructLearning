package impl;

import java.util.Iterator;


import dataStruct.exception.ElemenNotFoundException;
import dataStruct.exception.EmptyCollectionException;
import dataStruct.exception.NonComparableElementException;
import interfaces.BinarySearchTreeADT;
import model.BinaryTreeNode;

public class LinkedBinarySearchTree<T> implements BinarySearchTreeADT<T> {
	protected BinaryTreeNode<T> root;
	protected int modCount;
	
	/**
	 * Create an empty binary search tree
	 * */
	public LinkedBinarySearchTree() {
		root = null;
	}

	/**
	 * Creates a binary search search with the specified element as its root.
	 * @param element the element that will be the root of the new binary search tree
 	 * */
	public LinkedBinarySearchTree(T element){
		root = new BinaryTreeNode<T>(element);
		if(!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedBinarySearchTree");
	}
	
	@Override
	public T getRootElements() {
		// TODO Auto-generated method stub
		return root.getElement();
	}

	/***
	 * Returns true if this binary is empty and false otherwise.
	 * 
	 * @return true if this binary is empty, false otherwise.
	 * */
	@Override
	public boolean isEmpty() {
		
		return (modCount == 0);
	}
	
	/**
	 * Returns the number of elements in this binary tree
	 * @return the number of elements in the tree
	 * **/
	@Override
	public int size() {
		
		return modCount;
	}

	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		return (find(targetElement) != null);
	}

	/**
	 * Find the first element that matches the specified target
	 * element from the binary search tree and returns a reference to it.
	 * Throws a ElementNotFoundException if the specified target
	 * element is not found in the binary search tree
	 * @param targetElement the element being sought in the binary search tree
	 * @throws ElementNotFoundException if the target element is not found
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T find(T targetElement) throws ElemenNotFoundException {
		T result = null;
		if(isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else{
			BinaryTreeNode<T> parent = null;
			if(((Comparable<T>)targetElement).equals(root.getElement())){
				result = root.getElement();
			}else {
				parent = root;
				if(((Comparable)targetElement).compareTo(root.getElement()) < 0)
					result = findAgain(targetElement, root.getLeft(), parent);
				else 
					result = findAgain(targetElement, root.getRight(), parent);
			}
		}
		return result;
	}
	
	/**
	 * Finds the first element that matches the specified target element from the binary search tree
	 * and returns a reference to it. Throws an ElementNotFoundExcption if the specified target
	 * element is not found in the binary search tree
	 * @param targetElement the element being sought in the binary search tree
	 * @param node the node from which  to search
	 * @param parent the parent of the node from which to search
	 * @throws ElmementNotFoundException if the target element is not found
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private T findAgain(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) 
				throws ElemenNotFoundException{
		T result = null;
		
		if(node == null)
			throw new ElemenNotFoundException("LinkedBinarySearchTree");
		else{
			if(((Comparable<T>)targetElement).equals(node.getElement())){
				result = node.getElement();
			}else {
				parent = node;
				if(((Comparable)targetElement).compareTo(node.getElement()) < 0)
					result = findAgain(targetElement, node.getLeft(), parent);
				else {
					result = findAgain(targetElement, node.getRight(), parent);
				}
			}
		}
		return result;
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

	/**
	 * Adds the specified object to	the binary search tree in the
	 * appropriate position according to its natural order. Note that
	 * equal elements are added to the right
	 * 
	 * @param element the element to be added to the binary search tree
	 * */
	@Override
	public void addElemetn(T element) {
		if(!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedBinarySearchTree");
		Comparable<T> comparableElement = (Comparable<T>) element;
		 
		if(isEmpty())
			root = new BinaryTreeNode<T>(element);
		else {
			if(comparableElement.compareTo(root.getElement()) < 0){
				if(root.getLeft() == null)
					this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
				else	
					addElemetn(element, root.getLeft());
			}else{
				if(root.getRight() == null)
					this.getRootNode().setRight(new BinaryTreeNode<T>(element));
				else addElemetn(element, root.getRight());
			}
		}
		modCount++;
	}
	
	/**
	 * Adds the specified object to the binary search tree in the 
	 * appropriate position according to its natural order. Note that
	 * equal elements are added to the right
	 * @param element the element to be added to the binary search tree
	 * */
	@SuppressWarnings("unchecked")
	private void addElemetn(T element, BinaryTreeNode<T> node) {
		Comparable<T> comparableElement = (Comparable<T>) element;
		
		if(comparableElement.compareTo(node.getElement()) < 0){
			if(node.getLeft() == null)
				node.setLeft(new BinaryTreeNode<T>(element));
			else 
				addElemetn(element, node.getLeft());
		}else {
			if(node.getRight() == null)
				node.setRight(new BinaryTreeNode<T>(element));
			else
				addElemetn(element, node.getRight());
		}
		
	}

	private BinaryTreeNode<T> getRootNode() {
		return root;
	}

	/**
	 * Removes the first element that matches the specified target
	 * element from the binary search tree and returns a reference to it.
	 * Throws a ElementNotFoundException if the specified target
	 * element is not found in the binary search tree
	 * @param targetElement the element being sought in the binary search tree
	 * @throws ElementNotFoundException if the target element is not found
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public T removeElement(T targetElement) throws ElemenNotFoundException{
		T result = null;
		if(isEmpty())
			throw new ElemenNotFoundException("LinkedBinarySearchTree");
		else {
			BinaryTreeNode<T> parent = null;
			if(((Comparable<T>) targetElement).equals(root.getElement())){
				result = root.getElement();
				BinaryTreeNode<T> temp = replacement(root);
				if(temp == null)
					root = null;
				else{
					root = new BinaryTreeNode<T>(temp.getElement());
					root.setLeft(temp.getLeft());
					root.setRight(temp.getRight());
				}
				modCount--;
			}
			else{
				parent = root;
				if(((Comparable) targetElement).compareTo(root.getElement()) < 0)
					result = removeElement(targetElement, root.getLeft(), parent);
				else
					result = removeElement(targetElement, root.getRight(), parent);
			}
		}
		return result;
	}

	/**
	 * Removes the first element that matches the specified target element
	 * from the binary search tree and returns a reference to it. Throws a ElmentNotFoundException if the specified 
	 * target element is not found in the binary search tree
	 * @param targetElement the element being sought in the binary search tree
	 * @param node the node from which to search
	 * @param parent the parent of the node from which to search
	 * @throws ElementNotFoundException if the target element is not found
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) 
				throws ElemenNotFoundException{
		T result = null;
		if(node == null)
			throw new ElemenNotFoundException("LinkedBinarySearchTree");
		else{
			if(((Comparable<T>)targetElement).equals(node.getElement())){
				result = node.getElement();
				BinaryTreeNode<T> temp = replacement(node);
				if(parent.getLeft() == node)
					parent.setLeft(temp);
				if(parent.getRight() == node)
					parent.setRight(temp);
				modCount--;
			}else{
				parent = node;
				if(((Comparable)targetElement).compareTo(node.getElement()) < 0)
					result = removeElement(targetElement, node.getLeft(), parent);
				else
					result = removeElement(targetElement, node.getRight(), parent);
			}
		}
		
		return result;
	}

	/**
	 * Returns a reference to a node that will replace the one specified 
	 * for removal. In the case where the remove node has
	 * two children, the inorder successor is used ad its replacement.
	 * 
	 * @param node the node to be removed
	 * @return a reference to the replacing node
	 * */
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> result = null;
		
		if((node.getLeft() == null) && node.getRight() == null)
			result = null;
		else if((node.getLeft() != null) && (node.getRight() == null))
			result = node.getLeft();
		else if((node.getLeft() == null) && (node.getRight() != null))
			result = node.getRight();
		else {
			BinaryTreeNode<T> current = node.getRight();
			BinaryTreeNode<T> parent = node;
			 
			while (current.getElement() != null) {
				parent = current;
				current = current.getLeft();
			}
			
			current.setLeft(node.getLeft());
			if(node.getRight() != current){
				parent.setLeft(current.getRight());
				current.setRight(node.getRight());
			}
			result = current;
		}
		return result;
	}

	
	/**
	 * Removes elements that match the specified target element from
	 * the binary search tree. Throws a ElementNotFoundException if 
	 * the specified target element is not found in this tree
	 * @param targetElement the element being sought in the binary search tree
	 * @throws ElementNotFoundException if the target element is not found
	 * */
	@Override
	public void removeAllOccurenes(T targetElement)  throws ElemenNotFoundException{
		removeElement(targetElement);
		try{
			while (contains((T)targetElement))
				removeElement(targetElement);		
		}catch(Exception ElemenNotFoundException){
			System.out.println("No more element");
		}
		
	}

	/**
	 * Removes the node with the least value from the binary search
	 * tree and returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree is empty
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException if the tree is empty
	 * */
	@Override
	public T removeMin() throws EmptyCollectionException {
		T result = null;
		if(isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else{
			if(root.getLeft() == null){
				result = root.getElement();
				root = root.getRight();
			}else{
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> currnet = root.getLeft();
				while (currnet.getLeft() != null) {
					parent = currnet;
					currnet = currnet.getLeft();
				}
				result = currnet.getElement();
				parent.setLeft(currnet.getRight());
			}
			modCount--;
		}
		return result;
	}

	/**
	 * Removes the node with biggest value from the binary search
	 * tree and returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree and returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree is empty
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException if the tree is empty
	 * */
	@Override
	public T removeMax() throws EmptyCollectionException{
		T result = null;
		if(isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else {
			if(root.getRight() != null){
				result = root.getElement();
				root = root.getLeft();
			}else{
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.getRight();
				while(current.getRight() != null){
					parent = current;
					current = current.getRight();
				}
				result = current.getElement();
				parent.setRight(current.getLeft());
			}
			modCount--;
		}
		return result;
	}

	/**
	 * Find the node with least value from the binary search
	 * tree and returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree and returns a reference it its element. Throws an EmptyCollectionException if
	 * this tree is empty
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException if the tree is empty
	 * */
	@Override
	public T findMin() throws EmptyCollectionException{
		T result = null;
		if(isEmpty())
			throw new EmptyCollectionException("LinedBinarySearchTree");
		else{
			if(root.getLeft() != null){
				result = root.getElement();
				root = root.getLeft();
			}else{
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.getLeft();
				while (current.getLeft() != null) {
					parent = current;
					current = current.getLeft();
				}
				result = current.getElement();
			}
		}
		return result;
	}

	/**
	 * Find the node with biggest value from the binary search tree and 
	 * returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree is empty
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionExcption if the tree is empty
	 * */
	@Override
	public T findMax() throws EmptyCollectionException {
		T result = null;
		if(isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else {
			if(root.getRight() != null){
				result = root.getElement();
				root = root.getRight();
			}else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.getRight();
				while (current.getRight() != null) {
					parent = current;
					current = current.getRight();
				}
				result = current.getElement();
			}
		}
		return result;
	}

}
