package impl;


import java.util.Stack;

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
	
	
	public Node findNode(int value){
		Node current = root;
		while(current.getData() != value){
			if(value < current.getData())
				current = current.getLeftChild();
			else 
				current = current.getRightChild();
			if(current == null)
				return null;
		}
		return current;
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
	public boolean delete(int element){
		if(!find(element)){
			System.out.println("The element does not exist!");
			return false;
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
				return false;
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
		return true;
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
	
	/**
	 * 
	 * */
	public void traverse(int traverseType){
		switch (traverseType) {
		case 1: System.out.println("\nPreorder traversal: ");
			preOrder(root);
			break;

		case 2: System.out.println("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3: System.out.println("\nPostorder traversal: ");
	  		postOrder(root);
	  		break;
		}
		
		System.out.println();
	}

	private void postOrder(Node root) {
		if(root != null){
			postOrder(root.getLeftChild());
			postOrder(root.getRightChild());
			System.out.println(root.getData() + " ");
		}
	}

	private void preOrder(Node root) {
		if(root != null){
			System.out.println(root.getData() + " ");
			preOrder(root.getLeftChild());
			preOrder(root.getRightChild());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayTree(){
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("............................................");
		while(!isRowEmpty){
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int i = 0; i < nBlanks; i++)
				System.out.println(' ');
			while(!globalStack.isEmpty()){
				Node temp = (Node) globalStack.pop();
				if(temp != null){
					System.out.println(temp.getData());
					localStack.push(temp.getLeftChild());
					localStack.push(temp.getRightChild());
					
					if(temp.getLeftChild() != null ||
							temp.getRightChild() != null)
						isRowEmpty = false;
				}else{
					System.out.println("---");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks *2 -2; j++)
					System.out.println(' ');
			}      //end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
		System.out.println("...........................................................");
	}// end displayTree
}










































