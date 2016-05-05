package test;

import impl.ArrayIns;

public class QuickSortApp {

	public static void main(String[] args) {
		
		int maxSize = 50;
		ArrayIns arrayIns = new ArrayIns(maxSize);
		
		for (int i = 0; i < maxSize; i++) {
			int n = (int)(java.lang.Math.random() * 99);
			arrayIns.insert(n);
		}
		
		System.out.println(arrayIns.toString());
		arrayIns.quickSort();
		System.out.println(arrayIns.toString());

	}

}
