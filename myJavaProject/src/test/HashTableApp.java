package test;

import impl.HashTable;
import model.DataItem;

public class HashTableApp {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(30);
		hashTable.insert(new DataItem(11));
		hashTable.insert(new DataItem(1));
		hashTable.insert(new DataItem(22));
		hashTable.insert(new DataItem(32));
		hashTable.insert(new DataItem(41));
		hashTable.insert(new DataItem(51));
		hashTable.insert(new DataItem(61));
		hashTable.insert(new DataItem(71));
		hashTable.insert(new DataItem(81));
		hashTable.displayTable();
	}

}
