package model;

import javax.print.attribute.standard.MediaSize.Other;

public class Contact implements Comparable<Contact>{
	
	private String firstName, lastName, phone;
	
	/**
	 * Sets up this contact with the specified information
	 * 
	 * @param first a string representation of a first name
	 * @param last a string representation of  a last name
	 * @param phone a string representation of a phone number
	 * **/
	public Contact(String first, String last, String phone) {
		this.firstName = first;
		this.lastName = last;
		this.phone = phone;
	}
	
	/*
	 * Returns a description of this contact as a string
	 * @return a string representation of this contact
	 * */
	public String toString(){
		return lastName +", "+firstName + "\t" +phone;
	}
	

	/*
	 * Uses both last and first names to determine lexical ordering.
	 * 
	 * @param other the contact to be compared to this contact
	 * @return  the integer result of comparison
	 * */
	@Override
	public int compareTo(Contact orther) {
		int result;
		if(lastName.equals(orther.firstName))
			result = firstName.compareTo(orther.firstName);
		else 
			result = lastName.compareTo(orther.lastName);
		
		return result;
	}

}
