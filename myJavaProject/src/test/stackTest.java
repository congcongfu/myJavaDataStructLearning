package test;

import java.util.Stack;

import impl.ArrayQueue;
import interfaces.StackADT;

public class stackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayStack<Integer> stack = new ArrayStack<Integer>();
//		stack.push(new Integer(3));
//		stack.push(new Integer(4));
//		Integer y = stack.pop();
//		System.out.println(y);
//		stack.push(new Integer(7));
//		stack.push(new Integer(2));
//		stack.push(new Integer(5));
//		Integer z = stack.pop();
//		System.out.println(z);
//		Integer x = stack.peek();
//		System.out.println(x);
		ArrayQueue<String> queue = new ArrayQueue<String>();
		queue.enqueue("Eric");
		queue.enqueue("Tom");
		System.out.println(queue.size());
		System.out.println(queue.toString());
		
	}

}
