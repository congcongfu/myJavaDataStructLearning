package test;

import impl.ArrayList;
import model.Customer;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		list.add(3);
		list.add(9);
		list.add(3);
		list.add(6);
		list.add(12);
		list.add(7);
		list.add(23);
		System.out.println(list.size());
		System.out.println(list.toString());
		list.removes(3);
		System.out.println(list.toString());
		list.removeLast();
		System.out.println(list.first());
		System.out.println(list.last());
	}
	

}
