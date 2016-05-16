package model;

public class DataItem {
	public int dData;
	
	/*
	 * Create a new DataItem
	 * */
	public DataItem(int data){
		dData = data;
	}
	
	/**
	 * Returns the key of the item
	 * */
	public int getKey(){
		return dData;
	}
	
	/**
	 * Sets the key of the DataItem
	 * *
	 */
	public void setKey(int key){
		dData = key;
	}
	/**
	 * Displays the dataItem
	 * */
	public void displayItem(){
		System.out.println("/"+dData);
	}
}
