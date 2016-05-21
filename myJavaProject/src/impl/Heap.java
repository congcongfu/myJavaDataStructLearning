package impl;

import model.DataItem;

public class Heap {

	private DataItem[] heapArray;
	private int maxSize;                  //size of array
	private int currentSize;              //number of nodes in array
	
	/**
	 * Create a new Heap
	 * @param size of the heap
	 * */
	public Heap(int size){
		maxSize = size;
		currentSize = 0;
		heapArray = new DataItem[maxSize];   //create array
	}
	
	/**
	 * Returns true if the heap isEmpty
	 * @returns true if the heap isEmpty
	 * */
	public boolean isEmpty(){
		return (maxSize == 0);
	}
	
	/**
	 * Inserts a value into the heap
	 * @param key to be inserted into the heap
	 * @return true if done
	 * */
	public boolean insert(int key){
		if(currentSize == maxSize)
			return false;
		DataItem newNode = new DataItem(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	public void trickleUp(int index) {
		int parent = (index -1) / 2;
		DataItem bottom = heapArray[index];
		while(index > 0 && 
				heapArray[parent].getKey() < bottom.getKey()){
			heapArray[index] = heapArray[parent];    // move it down
			index = parent;
			parent = (parent -1) / 2;
		}
		heapArray[index] = bottom;
	}
	
	/**
	 * Remove the item with max in the heap
	 * @return DateItem contains the max key in the heap
	 * */
	public DataItem remove(){
		DataItem root = heapArray[0];
		heapArray[0] = heapArray[ --currentSize];
		trickleDown(0);
		return root;
	}

	private void trickleDown(int index) {
		int largerChild;
		DataItem top = heapArray[index];
		while(index < currentSize / 2){
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			
			if(rightChild < currentSize && 
					heapArray[leftChild].getKey() <
					heapArray[rightChild].getKey())
				largerChild = rightChild;
			else
				largerChild = leftChild;         //top >= largerChild?
			if( top.getKey() >= heapArray[largerChild].getKey())
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}
	
	public boolean change(int index, int newValue){
		if(index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getKey();      // remember old
		heapArray[index].setKey(newValue);				//change to new
		if(oldValue < newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}
	
	public void displayHeap(){
		System.out.println("heapAray: ");
		for(int i = 0; i < currentSize; i++){
			if(heapArray[i] != null)
				System.out.println( heapArray[i].getKey() +" ");
			else
				System.out.println("-- ");
		}
		System.out.println();
		
		int nBleaks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int i = 0;
		String dots = "......................";
		System.out.println(dots+dots);
		while(currentSize > 0){  //for each heap item
			if(column == 0)
				for (int j = 0; j < nBleaks; j++) {
					System.out.println(" ");
				}
			System.out.println(heapArray[i].getKey());
			if(++i == currentSize)
				break;
			if(++currentSize == itemsPerRow){
				nBleaks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}else
				for(int k = 0; k < nBleaks *2 -2; k++)
					System.out.println(" ");
		}
		System.out.println("\n"+dots+dots);
	}
	
	public void displayArray(){
		for(int i = 0; i < maxSize; i++)
			System.out.println(heapArray[i].getKey()+ " ");
		System.out.println("");
	}
	
	/**
	 * Insert a item into the correct index of the heap
	 * @param index of the heap to be insert
	 * @param item to be inserted
	 * */
	public void insertAt(int index, DataItem newItem){
		heapArray[index] = newItem;
	}
	
	/**
	 * Increase the size of heap
	 * */
	public void increaseSize(){
		currentSize++;
	}
}







































