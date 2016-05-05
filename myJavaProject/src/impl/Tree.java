package impl;


import dataStruct.exception.ElemenNotFoundException;
import model.Node;

public class Tree {

	private Node root;
	
	/**
	 * Finds the specified data in the tree
	 * @returns the found data
	 * */
	public Boolean find(int key){
		Node current = root;
		
		while(current.getData() != key){
			if(key < current.getData())
				current = current.getLeftChild();
			else 
				current = current.getRightChild();
			if(current == null)
				return false;
		}
		return (current != null);
	}
	
	/**
	 * Insert a data into the tree
	 * @param data the data to be be inserted
	 * */
	public void insert(int element){
		Node newNode = new Node(element);
		if(root == null)
			root = newNode;
		else{
			Node current = root;
			Node parent ;
			while(true){
				parent = current;
				if(element < current.getData()){
					current = current.getLeftChild();
					if(current == null){
						parent.setLeftChild(newNode);
						return;
					}
				}else {
					current = current.getRightChild();
					if(current == null){
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}
	
	public void order(){
		inOrder(root);
	}
	/**
	 *Travels the tree
	 * 
	 * */
	private void inOrder(Node root){
		if(root != null){
			inOrder(root.getLeftChild());
			System.out.println(root.getData() + " ");
			inOrder(root.getRightChild());
		}
	}
	
	
	/**
	 * Deletes the specified data in the tree
	 * @param int the targetElement
	 * */
	public void delete(int element){
		if(!find(element)){
			System.out.println("The element does not exist!");
			return;
		}
			
			
		Node current = root;
		Node parent  = root;
		boolean isLeftChild = true;
		
		while(current.getData() != element){
			parent = current;
			if(element < current.getData()){
				isLeftChild = true;
				current = current.getLeftChild();
			}else {
				isLeftChild = false;
				current = current.getRightChild();
			}
			if(current == null)
				return;
		}
		
		/*Delete element without children*/
		if(current.getLeftChild() == null && current.getRightChild() == null){
			if(current == root)
				root = null;
			else if(isLeftChild)
				parent.setLeftChild(null);
			else 
				parent.setRightChild(null);
		}
		/*Delete element without right child*/
		else if (current.getRightChild() == null) {
			if(current == root)
				root = current.getLeftChild();
			else if (isLeftChild)
				parent.setLeftChild(current.getLeftChild());
			else 
				parent.setRightChild(current.getLeftChild());
		}
		
		/*delete element without left child*/
		else if (current.getLeftChild() == null) {
			if(current == root)
				root = current.getRightChild();
			else if(isLeftChild)
				parent.setLeftChild(current.getRightChild());
			else 
				parent.setRightChild(current.getRightChild());
		}
		/*Delete the element has two children*/
		else if (current.getLeftChild() != null && current.getRightChild() != null) {
			Node successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if (isLeftChild)
				parent.setLeftChild(successor);
			else
				parent.setRightChild(successor);
			successor.setLeftChild(current.getLeftChild());
		}
	}
	
	/**
	 * Finds the minimum value in the tree
	 * @returns a number which is minimum in the tree;
	 * */
	public int minimum() throws ElemenNotFoundException{
		Node current, last = null;
		current = root;
		while(current != null){
			last = current;
			current = current.getLeftChild();
		}
		if(last == null)
			throw new ElemenNotFoundException("Binary tree");
		else
			return last.getData();
	}
	
	/**
	 * Find the maximum value in the tree
	 * @returns a number which is maximum in the tree
	 * */
	public int maximum() throws ElemenNotFoundException{
		Node current, last = null;
		current = root;
		while(current != null){
			last = current;
			current = current.getRightChild();
		}
		if(last != null)
			return last.getData();
		else
			throw new ElemenNotFoundException("Binary tree");
	}
	
	/**
	 * Finds the node to replace the targetNode
	 * @returns Node node to replace the node to be deleted
	 * */
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.getRightChild();
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		if(successor != delNode.getRightChild()){
			successorParent.setLeftChild(successor.getRightChild());
			successor.setRightChild(delNode.getRightChild());
		}
		return successor;
	}
	
}










































