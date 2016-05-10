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

	private Node_3 getNextChild(Node_3 curNode, int key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * */
	public void insert(int dValue){
		Node_3 curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while(true){
			if(curNode.isFull()){
				spilt(curNode);
				curNode = getNextChild(curNode, dValue);
			}   //end if(node is full)
			
			else if(curNode.isLeaf())    //if node is leaf
				break;                  // go insert
			else
				curNode = getNextChild(curNode, dValue);
		}
		curNode.insertItem(tempItem);        //insert new DataItem
	}

	/**
	 * Removes items from this node 
	 * remove children from this node
	 * */
	private void spilt(Node_3 thisNode) {
		DataItem itemB, itemC;
		Node_3 parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();    
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChid(2);
		child3 = thisNode.disconnectChid(3);
		
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
			Node_3 temp = parent.disconnectChid(j);
			parent.connectChild(j+1, temp);
		}
		
		parent.connectChild(itemIndex+1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
}



























