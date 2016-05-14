package impl;

import model.DataItem;

public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	/**
	 * Creates a new hashTable
	 * @param size of the arraySize
	 * */
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	/**
	 * Display The hashTable
	 * */
	public void displayTable(){
		System.out.println("Table: ");
		for(int j = 0; j < arraySize; j++){
			if(hashArray[j] != null)
				System.out.println(hashArray[j].getKey()+" ");
			else
				System.out.println("** ");
		}
		System.out.println("");
	}
	
	/**
	 * Hash function
	 * @returns the index of the array
	 * */
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	/**
	 * Inserts a data into the hash table
	 * @param item to be inserted into the table 
	 * */
	public void insert(DataItem item){
		int key = item.getKey();
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null &&
				hashArray[hashVal].getKey() != -1){
			++hashVal;                              // go to the next cell
			hashVal %= arraySize;					//wrap around if necessary
		}
		hashArray[hashVal] = item;
	}
	
	/**
	 * Delete the specified key in the table
	 * @param key to be deleted
	 * @returns DataItem temp 
	 * */
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;                          //find the item
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
	
	/**
	 * Finds the specified key in the table
	 * @param specified key
	 * @returns DataItem
	 **/
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){
				DataItem temp = hashArray[hashVal];   //find the item
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}































