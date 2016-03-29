package test;

import impl.UnorderedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnorderedList<Integer> unorderedList = new UnorderedList<Integer>();
		unorderedList.add(5);
		unorderedList.add(6);
		unorderedList.add(7);
		unorderedList.add(11);
		unorderedList.add(9);
		unorderedList.add(9);
		System.out.println(unorderedList.size());
		unorderedList.removeFirst();
		unorderedList.removeLast();
		System.out.println(unorderedList.toString());
		
	}

}
