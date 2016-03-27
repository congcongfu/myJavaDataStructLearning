package model;

public class Customer {
	private int arrivaltime;
	private int departureTime;
	
	public Customer(int arrives) {
		arrivaltime = arrives;		
		departureTime = 0;
	}//

	/*Returns the arrival time of this customer
	 * @return the arrival time
	 * */
	public int getArrivaltime() {
		return arrivaltime;
	}

	/*Sets the departure time for this customer.
	 * @param departs the arrivaltime time
	 * */
	public void setArrivaltime(int arrives) {
		this.arrivaltime = arrives;
	}
	
    /*Returns the departure time of this customer;
     * @returns the departure time
     * */
	public int getDepartureTime() {
		return departureTime;
	}
	/*Set the departure time for this customer
	 * @param departs the departure time*/
	public void setDepartureTime(int departs) {
		this.departureTime = departs;
	}
	
	/*customer and returns the total time spent by this customer.
	 * @return the total customer time
	 * */
	public int totalTime(){
		return departureTime - arrivaltime;
	}

}
