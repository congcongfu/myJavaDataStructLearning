package impl;

import java.awt.RenderingHints.Key;

import model.Link;
import model.SortedList;

public class HashTable2 {
	private SortedList[] hashArray;
	private int arraySize;
	
	/**
	 * Create a new hashTable
	 * @param size of the table
	 * */
	public HashTable2(int size){
		arraySize = size;
		
		hashArray = new SortedList[arraySize];  //create array
		for(int i = 0; i < arraySize; i++){
			hashArray[i] = new SortedList();  // fill array with lists
		}
	}
	
	/**
	 * Display the table
	 * */
	public void displayTable(){
		for( int i = 0; i < arraySize; i++){
			System.out.println(i +". ");    //display cell number
			hashArray[i].displayList();
		}
	}
	
	/***
	 * Hash function
	 * @return the index the list will be sorted in the table
	 * */
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	/**
	 * Insert a link to the table
	 * @param Link to be insert into the table
	 * */
	public void insert(Link newLink){
		int key = newLink.getKey();
		int hashVal = hashFunc(key);     //hash the key
		hashArray[hashVal].insert(newLink);    // insert at hashVal
	}
	
	/***
	 * Delete a specified value in the table
	 * @param key to be deleted
	 * */
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	
	/**
	 * Finds a specified key in the table
	 * 
	 * @param key to be found in the table
	 * */
	public Link find(int key){
		int hashVal = hashFunc(key);
		return hashArray[hashVal].find(key); 
	}
}




























