package test;

import impl.HashTable2;
import model.Link;

public class HashChainApp {

	public static void main(String[] args) {

		HashTable2 hashTable = new HashTable2(20);
		hashTable.insert(new Link(1));
		hashTable.insert(new Link(2));
		hashTable.insert(new Link(3));
		hashTable.insert(new Link(21));
		hashTable.insert(new Link(41));
		hashTable.insert(new Link(22));
		hashTable.insert(new Link(32));
		hashTable.insert(new Link(42));
		hashTable.insert(new Link(52));
		hashTable.insert(new Link(62));
		hashTable.insert(new Link(72));
		hashTable.insert(new Link(82));
		hashTable.insert(new Link(18));
		hashTable.insert(new Link(20));
		hashTable.insert(new Link(30));



		hashTable.displayTable();

	}

}

































