package dataStruct.exception;

public class NonComparableElementException extends RuntimeException {
	public NonComparableElementException(String orderedList){
		super("The " + orderedList +" is empty");
	}
}
