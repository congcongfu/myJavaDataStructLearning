package impl;

import java.util.Arrays;

import dataStruct.exception.EmptyCollectionException;
import interfaces.StackADT;

public class ArrayStack<T> implements StackADT<T> {
	private final int DEFAUL_CAPACITY = 100;
	private int top;
	private T[] stack;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		top = 0;
		stack = (T[]) (new Object[DEFAUL_CAPACITY]);
	}  

	public ArrayStack(int initialCapacity) {
		top = 0;
		stack = (T[]) (new Object[initialCapacity]);
	}
	
	/*Create a new array to store the contents of this stack with
	 * twice the capacity of the old one
	 * */
	private void expandCapacity(){
		stack = Arrays.copyOf(stack, stack.length * 2);
	}
	
	/* Adds the specified elements to the top of this stack, expanding
	 * the capacity of array if necessary.
	 * @param elemnet genetic element to be pushed onto stack*/
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		if(size() == stack.length)
			expandCapacity();
		stack[top] = element;
		top++;

	}

	/*remove the element of the top of this stack and return a
	 * reference to it
	 * @return element remove from top of stack
	 * @throws EmptyCollectionException if stack id empty*/
	@Override
	public T pop() throws EmptyCollectionException{
		// TODO Auto-generated method stub
		if(isEmpty()) 
			throw new EmptyCollectionException("Stack");
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyCollectionException("Stack");
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}

}
