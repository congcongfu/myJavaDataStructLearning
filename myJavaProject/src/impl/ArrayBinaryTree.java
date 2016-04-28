package impl;

import java.util.Iterator;

import interfaces.BinaryTreeADT;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
	
	private static final int DEFAULT_CAPACITY = 50;
	
	protected int count;
	protected T[] tree;
	protected int modCount;

	/**
	 * Creates an empty binary tree.
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayBinaryTree() {
		count = 0;
		tree = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	/**
	 * Creates a binary tree with the specified element as its root.
	 * 
	 * @param element the element which will become the root of the new tree
	 * */
	public ArrayBinaryTree(T element){
		count = 1;
		tree = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	/*
	 * Expand the capacity of the list twice
	 * */
	@SuppressWarnings("unchecked")
	public void expandCapacity(){
		tree = (T[]) (new Object[DEFAULT_CAPACITY * 2]);
		modCount *= 2;
	}
	
	@Override
	public T getRootElements() {
		return null;
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
