package test;

import impl.Tree;

public class TreeApp {

	public static void main(String[] args) {
		Tree theTree = new Tree();
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);
		theTree.insert(100);
		theTree.delete(80);
		theTree.order();
	}

}
