package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		int numPeople, skip, targetIndex;
		
		List<String> list = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		/*get the initial number of soldiers*/
		System.out.println("Enter the number of soldiers: ");
		numPeople = in.nextInt();
		
		/*get the number of soldiers to skip*/
		System.out.println("Enter the number of soldiers to skip: ");
		 skip = in.nextInt();
		 
		 /*load the initial list of soldiers*/
		 for(int i = 0; i <= numPeople; i++){
			 list.add("Soldier "+ i);
		 } 
		 
		 targetIndex = skip;
		 System.out.println("The order is : ");
		 
		 /*Treating the list as circular, remove every nth element
		  * until the list is empty*/
		 while (!list.isEmpty()) {
			System.out.println(list.remove(targetIndex));
			if(list.size() > 0){
				targetIndex = (targetIndex + skip) % list.size();
			}
			
		}

	}

}
