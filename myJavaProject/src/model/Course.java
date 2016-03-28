package model;

import java.io.Serializable;

public class Course implements Serializable {
	private String prefix;
	private int number;
	private String title;
	private String grade;
	
    /*
     * Constructs the course with the specified information.
     * 
     * @param prefix the prefix of the course designation
     * @param number the number of the course designation
     * @param title the title of the course
     * @param grade the grade received for the course
     * */
	public Course(String prefix, int number, String title, String grade){
		this.prefix = prefix;
		this.number = number;
		this.title = title;
		if(grade == null){
			this.grade= "";
		}else {
			this.grade = grade;
		}
	}
	
	/*
	 * Constructs the course with the specified information , with no
	 * grade established
	 * @param prefix the prefix of the course designation
	 * @param number the number of the course designation
	 * @param title the title of the course
	 * */
	public Course(String prefix, int number, String title){
		this(prefix, number, title, "");
	}

	/*
	 * Returns the prefix of the course designation
	 * @return the prefix of the course designation
	 * */
	public String getPrefix() {
		return prefix;
	}

	/*
	 * Sets the prefix for this course to the one specified
	 * 
	 *  @param prefix the new prefix for the course
	 * */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/*
	 * Returns the number of the course designation
	 * @return the number of the course designation
	 * */
	public int getNumber() {
		return number;
	}

	/*
	 * Set the number for this course to the one specified
	 * @param number the number for the course
	 * */
	public void setNumber(int number) {
		this.number = number;
	}
 
	/*
	 * Returns the title of the course designation
	 * @return the title of the course designation
	 * */
	public String getTitle() {
		return title;
	}

	/*
	 * Set the title for this course to the one specified
	 * @param title the title for the course
	 * */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * Returns the grade of the course designation
	 * @return the grade of the course designation
	 * */
	public String getGrade() {
		return grade;
	}
		
	/*
	 * Set the grade for this course to the one specified
	 * @param grade the grade for the course
	 * */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/*
	 * Returns true if this course has been taken (if a grade has been received)
	 * @return true if this course has been taken and false otherwise
	 * */
	public boolean taken(){
		return !grade.equals("");
	}
	
	/*
	 * Determines if this course is equal to the one speciefied , based
	 * on the course designation (prefix and number)
	 * 
	 * @return true if this course is equal to the parameter
	 * */
	public boolean equals(Object other){
		boolean result = false;
		if(other instanceof Course){
			Course otherCourse = (Course) other;
			if(prefix.equals(otherCourse.getPrefix()) &&
					number == otherCourse.getNumber())
				result = true;
		}
		return result;
	}
	
	/*
	 * Creates and returns a string representation of this course
	 * 
	 * @return a string representation of the course
	 * */
	public String toString(){
		String restult = prefix+ " " +number + ": " +title;
		if (!grade.equals("")) {
			restult += " [" + grade + "] ";
		}
		
		return restult;
	}
}





























