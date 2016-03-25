package dataStruct.exception;

public class EmptyCollectionException extends RuntimeException{
	/*Sets up this exception with an appropriate message
	 * @param collection the name of collection
	 * */
	public EmptyCollectionException(String collection){
		super("The " + collection +" is empty");
	}
}
