package impl;

import dataStruct.exception.EmptyCollectionException;
import interfaces.QueueADT;
import model.LinearNode;

public class LinkedQueue<T> implements QueueADT<T> {
	private int count;
	private LinearNode<T> head, tail;
	
	public LinkedQueue() {
		// TODO Auto-generated constructor stub
		count = 0;
		head = tail = null;
	}
	
	/*
	 * add the specified element to the tail of this queue.
	 * @param element the element to be added to the tail of this queue.
	 * */
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		LinearNode<T> node = new LinearNode<T>(element);
		
		if(isEmpty()){
			head = node;
		}else {
			tail.setNext(node);
		}
		tail = node;
		count++;
	}

	@Override
	public T dequeue() throws EmptyCollectionException{
		if(isEmpty()){
			throw new EmptyCollectionException("queue is empty");
		}
		
		T result = head.getElement();   //
		 head  = head.getNext();
		 count--;
		 
		 if(isEmpty()){
			 tail = null;
		 }
		return result;
	}

	@Override
	public T first() throws EmptyCollectionException{
		// TODO Auto-generated method stub
		if (isEmpty()){
			throw new EmptyCollectionException("queue is empty");
		}
		return head.getElement();
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	/*
	 * Returns a String representation of the LinkedQueue.
	 * */
	public String toString(){
		String result="[";
		LinearNode<T> current = head;
		while (current != null){
			result = result + current.toString() ;
			current = current.getNext();
			if (current != null) {
				result += ",";
			}
		}
		result += "]";
		
		return result;
	}

}
