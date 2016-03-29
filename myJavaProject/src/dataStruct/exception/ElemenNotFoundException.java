package dataStruct.exception;

public class ElemenNotFoundException extends RuntimeException {
	
	/*Sets up this exception with an appropriate message
	 * @param element the name of element
	 * */
	public ElemenNotFoundException(String element){
		super("The " + element +" is empty!");
	}
}
