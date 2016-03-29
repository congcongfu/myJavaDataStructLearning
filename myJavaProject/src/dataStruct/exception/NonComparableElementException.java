package dataStruct.exception;

public class NonComparableElementException extends RuntimeException {
	/*Sets up this exception with an appropriate message
	 * @param orderedList the name of orderedList
	 * */
	public NonComparableElementException(String orderedList){
		super("The " + orderedList +" is empty");
	}
}
