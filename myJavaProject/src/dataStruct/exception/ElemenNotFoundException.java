package dataStruct.exception;

public class ElemenNotFoundException extends RuntimeException {
	
	/*Sets up this exception with an appropriate message
	 * @param collection the name of collection
	 * */
	public ElemenNotFoundException(String element){
		super("The " + element +" is empty!");
	}
}
