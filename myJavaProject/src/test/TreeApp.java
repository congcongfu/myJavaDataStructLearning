package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

import impl.Tree;
import model.Node;

public class TreeApp {

	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);
		theTree.insert(100);
		theTree.insert(80);
		theTree.insert(90);
		theTree.insert(20);
		
		while(true){
			System.out.println("Enter first letter of show");
			System.out.println("insert, find , delete, or traverse: ");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;

			case 'i':
				System.out.println("Enter value to insert: ");
				value = getInt();
				theTree.insert(value);
				break;
				
			case 'f':
				System.out.println("Enter value to find: ");
				value = getInt();
				Node found = theTree.findNode(value);
				if(found != null){
					System.out.println("Found: ");
					found.displayNode();
					System.out.println("\n");
				}else
					System.out.println("Could nor find ");
					System.out.println(value+ "\n");
					break;
					
			case 'd':
				System.out.println("Enter value to delete: ");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if(didDelete)
					System.out.println("Deleted "+ value + '\n');
				else 
					System.out.println("Could not delete ");
				  	System.out.println(value + '\n');
				  	break;
			
			 case 't':
				 System.out.println("Enter type 1, 2 or 3: ");
				 value = getInt();
				 theTree.traverse(value);
				 break;
			 default:
				 System.out.println("Invalid entry\n");
			}
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(inputStreamReader);
		String string = bReader.readLine();
		return string;
	}
	
	public static char getChar() throws IOException{
		 String string = getString();
		 return string.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}



































