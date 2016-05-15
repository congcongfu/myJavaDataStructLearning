package model;

public class SortedList {
	private Link first;
	
	/**
	 * Create a new empty SortedList
	 * */
	public void SortedList(){
		first = null;
	}
	
	/**
	 * Inserts link in order
	 * */
	public void insert(Link newLink){
		int key = newLink.getKey();
		Link previous = null;
		Link current = first;
		while( current != null && key > current.getKey()){
			previous = current;
			current = current.next;           //go to the next item
		}
		if(previous == null)                 // if beginning of list
			first = newLink;
		else
			previous.next = newLink;
		newLink.next = current;
	}
	
	/**
	 * Deletes the key in the link
	 * @param key of the value in the link
	 * */
	public void delete(int key){
		Link previous = null;
		Link current = first;
		
		while( current != null && key != current.getKey()){
			previous = current;
			current = current.next;
		}
		
		if(previous == null)
			first = first.next;
		else
			previous.next = current.next;  //delete current link
	}
	
	
	/**
	 * Finds the key in the link
	 * @param key of the value in the link
	 * @returns Link be found to represent the key
	 * */
	public Link find(int key){
		Link current = first;
		while(current != null && current.getKey() <= key){
			if(current.getKey() == key)
				return current;
			current = current.next;
		}
		return null;
	}
	
	/**
	 * Display the value in the link
	 * */
	public void displayList(){
		System.out.println("List (first --> last) ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	/**
	 * Returns a String to represents the list
	 * @returns string to represents the list
	 * */
	public String toString(){
		String result = "{";
		Link current = first;
		while(current != null){
			if(current.next != null){
				result += current.getKey() + ",";
			}else
				result += current.getKey();
		}
		
		return result + "}";
	}
}



































