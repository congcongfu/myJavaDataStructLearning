package impl;

import model.DataItem;
import model.Node_3;

public class Tree234 {
	private Node_3 root = new Node_3();
	
	public int find(int key){
		Node_3 curNode = root;
		int childNumber;
		while(true){
			if( (childNumber = curNode.findeItem(key)) != -1)
				return childNumber;         //found it
			else if(curNode.isLeaf()) 
				return -1;					//can't find it
			else 							//search deeper
				curNode = getNextChild(curNode, key);
		}
	}

	/**
	 * Gets appropriate child of node during search for value
	 * */
	private Node_3 getNextChild(Node_3 curNode, int key) {
		int i;
		int numItems = curNode.getNumItems();
		for (i = 0; i < numItems; i++) {
			if( key < curNode.getItem(i).dData){
				return curNode.getChild(i);    //return left child
			}
		}
		
		return curNode.getChild(i);
	}
	
	/**
	 * Inserts the a specified value into the tree
	 * @param int dValue to be inserted into the tree
	 * */
	public void insert(int dValue){
		Node_3 curNode = root;
		Node_3 nextChild;
		DataItem tempItem = new DataItem(dValue);
		while(true){
			if(curNode.isFull()){
				split(curNode);
				nextChild = getNextChild(root, dValue);
				if(nextChild != null)
						curNode = nextChild;
			}else if(curNode.isLeaf()){    //if node is leaf
				break;                  // go insert
			}else{
					curNode = getNextChild(curNode, dValue);
				} 
		}
		curNode.insertItem(tempItem);   //insert new DataItem
		
		    
	}

	/**
	 * Splits the items if it is full 
	 * */
	private void split(Node_3 thisNode) {

		DataItem itemB, itemC;
		Node_3 parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();    
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);
		Node_3 newRight = new Node_3();
		
		if(thisNode == root){
			root = new Node_3();
			parent = root;
			root.connectChild(0, thisNode);
		}
		else
			parent = thisNode.getParent();
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		
		for(int j = n-1; j > itemIndex; j--){
			Node_3 temp = parent.disconnectChild(j);
			parent.connectChild(j+1, temp);
		}

		parent.connectChild(itemIndex+1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public void displayTree(){
		recDisplayTree(root, 0, 0);
	}

	/**
	 * display the tree
	 * */
	private void recDisplayTree(Node_3 thisNode, int level, int childNumber) {

		System.out.println("level="+level+" child="+childNumber+" ");
		thisNode.diplayNode();
		
		//call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for(int i = 0; i < numItems+1; i++){
			Node_3 nextNode = thisNode.getChild(i);
			if(nextNode != null){
				recDisplayTree(nextNode, level+1, i);
			}else{
				return;
			}
		}
	}
}



























