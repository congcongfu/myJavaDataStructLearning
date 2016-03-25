package dataStruct.exception;

public interface StackADT<T> {
	/*
	 * add the specified element to the top of this stack
	 * @param element element to pushed onto the stack
	 * */
	public void push(T element);
	
	/*
	 * remove and return the top element from this stack
	 * @return the element removed from the stack
	 * */
	public T pop();
	
	/*
	 * Returns without removing the pop element of this stack.
	 * @return the element on top of the stack
	 * */
	public T peek();
	
	/*
	 * Returns true if this stack contains on elements
	 * @return true if the stack is empty
	 * */
	public boolean isEmpty();
	
	/*Returns the number of elements in this stack
	 * @return the number of elements in the stack
	 * */
	public int size();
	
	/*
	 * Returns a string representation of this stack.
	 * return a string representation of stack
	 * */
	public String toString();
	
	
}









