package model;

import javax.tools.Tool;

/**
 * @author fucong @2016/05/19
 * 
 * */
public class StackX {

	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	/**
	 * constructor
	 * create a new StackX
	 * */
	public StackX() {
		st = new int[SIZE];
		top = -1;
	}
	
	/**
	 * puts item on stack
	 * @param item to be pushed
	 * */
	public void push(int item){
		st[++top] = item;
	}
	
	/**
	 * Takes item off stack
	 * @return in the popped in stack
	 * */
	public int pop(){
		return st[top--];
	}
	
	/**
	 * Peek at top at stack
	 * @return the top item in the stack
	 * */
	public int peek(){
		return st[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
}






















