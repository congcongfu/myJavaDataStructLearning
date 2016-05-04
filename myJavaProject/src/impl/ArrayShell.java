package impl;

public class ArrayShell {

	private int[] theArray;
	private int count;
	
	/**
	 * Create a new empty ArrayShell
	 * @param int number size of the ArrayShell
	 * */
	public ArrayShell(int max){
		theArray = new int[max];
		count = 0;
	}
	
	/***
	 * Insert a number into the Array;
	 * @param long value to be insert into the Array
	 * */
	public void insert(int value){
		theArray[count] = value;
		count++;
	}
	
	/**
	 * Displays array contents
	 * */
	public void display(){
		System.out.println("A=");
		for(int j = 0; j < count; j++)       
			System.out.println(theArray[j] + " ");
		System.out.println("");
	}
	
	/**
	 * Sort the array in an order;
	 * */
	public void shellSort(){
		int inner, outer;
		int temp;
		
		int h = 1;      //find the initial value of h
		while(h < count/ 3)
			h = h * 3 +1;
		
		while(h > 0){     
			for(outer = h; outer < count; outer++){
				temp = theArray[outer];
				inner = outer;
				
				while(inner > h -1 && theArray[inner - h] >= temp){
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}//end for;
			h = (h -1) / 3; //decrease h
		}  //end shellSort()
	}
	
	/**
	 * Returns a string to represents the array
	 * @returns a string to represents the array
	 * */
	public String toString(){
		String result = "{";
		for(int i = 0; i < count; i++){
			if(i < count -1)
				result += theArray[i] + ",";
			else 
				result += theArray[i];
		}
		result += "}";
		return result;
	}
}








































