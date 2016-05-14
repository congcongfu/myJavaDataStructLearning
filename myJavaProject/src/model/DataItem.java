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
	 * Displays the dataItem
	 * */
	public void displayItem(){
		System.out.println("/"+dData);
	}
}
