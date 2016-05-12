package model;


public class Node_3 {
	public static final int ORDER = 4;
	private int numItems;
	private Node_3 parent;
	private Node_3 childArray[] = new Node_3[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER -1];
	
	/**
	 * Connects child to this node
	 * @param number of the children
	 * @param Node_3 child
	 * */
	public void connectChild(int childNum, Node_3 child){
		childArray[childNum] = child;
		if(child != null)
			child.parent = this;
	}
	
	/***
	 * Disconnect child from this node return it
	 *@param the number of the child 
	 *@returns Node_3 tempNode to be disconnected
	 * */
	public Node_3 disconnectChild(int childNum){
		Node_3 tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	/**
	 *Finds and return a child of the node
	 *@param the number to represents the child of the node
	 *@returns Node_3 to represent the child found;
	 * */
	public Node_3 getChild(int childNum){
		return childArray[childNum];
	}
	
	/**
	 * Gets the parent
	 * @returns Node_3 parent
	 * */
	public Node_3 getParent(){
		return parent;
	}
	
	/**
	 * Returns true if the element is leaf , false otherwise;
	 * @returns boolean
	 * */
	public boolean isLeaf(){
		return (childArray[0] == null) ? true: false;
	}
	
	/**
	 * Gets the number of the item
	 * @return numItems to represents the number of the item
	 * */
	public int getNumItems(){
		return numItems;
	}
	
	/**
	 * Gets DataItem at index
	 * @return DataItem at index
	 * */
	public DataItem getItem(int index){
		return itemArray[index];
	}
	
	/**
	 * Returns true if the node is full, false otherwise;
	 * @returns boolean
	 * */
	public boolean isFull(){
		return (numItems == ORDER-1) ? true : false;
	}
	
	/**
	 * Returns index of item if found otherwise return -1 
	 * @return 
	 **/
	public int findeItem(int key){
		for (int i = 0; i < ORDER -1; i++) {
			if(itemArray[i] == null)
				break;
			else if(itemArray[i].dData == key)
				return i;
		}
		return -1;
	}
	
	/**
	 * Inserts the DataItem into node
	 * @return
	 * */
	public int insertItem(DataItem newItem){
		numItems++;
		int newKey = newItem.dData;
		
		for (int i = ORDER -2; i >= 0; i--) {
			if(itemArray[i] == null)
				continue;
			else {
				int itsKey = itemArray[i].dData;
				if(newKey < itsKey)                   //if it's bigger
					itemArray[i + 1] = itemArray[i];   //shift it right
				else {
					itemArray[i+1] = newItem;          //insert new item
					return i+1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	
	/**
	 * Removes the largest item in the node
	 * @return DataItem to be removed
	 * */
	public DataItem removeItem(){
		DataItem temp = itemArray[numItems -1];   //save item
		itemArray[numItems -1] = null;
		numItems--;
		return temp;
	}
	
	/**
	 * Display the node
	 * */
	public void diplayNode(){
		String result = "{";
		for (int i = 0; i < numItems; i++) {
			itemArray[i].displayItem();
		}
		System.out.println("/");
	}
	
	/* */
	public String toString(){
		String result = "{";
		for (int i = 0; i < numItems; i++) {
			if(i < numItems -1)
				result += itemArray[i].dData+ ",";
			else {
				result += itemArray[i].dData;
			}
		}
		return result += "}";
	}
}



















































