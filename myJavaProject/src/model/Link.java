package model;

public class Link {
	private int dData;
	public Link next;
	
	public Link(int data){
		dData = data;
	}
	
	public int getKey(){
		return dData;
	}
	
	public void displayLink(){
		System.out.println(dData + " ");
	}

}
















