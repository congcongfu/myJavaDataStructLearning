package model;

import java.util.LinkedList;
import java.util.Queue;


public class TicketCounter {
	final static int PROCESS = 120;
	final static int MAX_CASHIERS = 10;
	final static int NUM_CUSTOMERS = 100;

	public static void main(String[] args){
		Customer customer;
		Queue<Customer> customerQueue = new LinkedList<Customer>();
		int [] cashinerTimer = new int [MAX_CASHIERS];
		int totalTime = 0, averageTime, departs, start;
		
		/*process the simulation for various number of cashiers*/
		for (int cashier = 0; cashier < cashinerTimer.length; cashier++){
			/*set each cashier time to zero initially*/
			for (int count = 0; count < cashier; count++){
				cashinerTimer[count] = 0;
			}
			
			/*load customer queue*/
			for(int count = 1; count < NUM_CUSTOMERS; count++){
				customerQueue.add(new Customer(count * 15));
				totalTime = 0;
			}
			
			/*process all customers in the queue*/
		while (!(customerQueue.isEmpty())){
			for(int count = 0; count <= cashier; count++){
				if(!(customerQueue.isEmpty())){
					customer = customerQueue.remove();
					if(customer.getArrivaltime() > cashinerTimer[count]){
						start = customer.getArrivaltime();
					}else {
						start = cashinerTimer[count];
					}
					departs = start + PROCESS;
					customer.setDepartureTime(departs);
					cashinerTimer[count] = departs;
					totalTime += customer.totalTime();
				}
			}
		}
		
		/*output results for this simulation*/
		averageTime = totalTime / NUM_CUSTOMERS;
		System.out.println("Number of cashiers: " +(cashier +1));
		System.out.println("Average timer: " + averageTime + "\n");
		}
		
	}
}
