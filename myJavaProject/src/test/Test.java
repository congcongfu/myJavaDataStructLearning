package test;

import impl.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		String name = "EricFu";
		String first = name.substring(0, 2);
		String last = name.substring(name.length() -2, name.length());
		name = first+"***"+last;
		System.out.println(first);
		System.out.println(last);
		System.out.println(name);
		
		
	}
	public static int sum(int num){
		int result;
		if(num == 1)
			result = 1;
		else 
			result = num * sum(num -1);
		return result;
		
	}

}
