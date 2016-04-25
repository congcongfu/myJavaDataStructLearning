package interfaces;

/**
 * BinarySearchTreeADT defines the interface to a binary search tree
  * */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
	
	/**
	 * Adds the specified element to the proper location in this tree
	 * @param element the element the element to be added to this tree
	 * */
	public void addElemetn(T element);
	
	/**
	 * Removes and returns the specified element from this tree.
	 * @param targetElement the element to be removed from this tree
	 * @return the element to be remove the added to this tree
	 * */
	public T removeElement(T targetElement);
	
	/**
	 * Remove all occurences of the specified element from this tree.
	 * @param targetElement the element to be remove from the tree.
	 * */
	public void removeAllOccurenes(T targetElement);
	
	/**
	 * Removes and returns the smallest element from this tree
	 * @return the smallest element from the tree
	 * */
	public T removeMin();
	
	/**
	 * Removes and return the largest element from this tree.
	 * return the largest element from the tree
	 * */
	public T removeMax();
	
	/**
	 * Returns the smallest element from this tree without removing it.
	 * 
	 * @return the smallest element in the tree
	 * */
	public T findMin();
	
	/**
	 * Return the largest element in this tree without removing it
	 * @return the largest element in the tree
	 * */
	public T findMax();

}

























