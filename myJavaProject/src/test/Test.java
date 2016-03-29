package test;

import impl.LinkedList;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(6);
		System.out.println(list.size());
		System.out.println(list.first());
		System.out.println(list.last());
		list.removeFirst();
	    list.remove(3);
		System.out.println(list.contains(0));
		System.out.println(list.toString());
		
	}

}
