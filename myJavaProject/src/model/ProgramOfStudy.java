package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProgramOfStudy implements Iterable<Course>, Serializable {
	private List<Course> list;

	
	/*Constructs an initially empty program of Study
	 * */
	public ProgramOfStudy(){
		list = new LinkedList<Course>();
	}
	
	/*
	 * Adds the specified course to the end of the course list.
	 * 
	 * @param course the course to add
	 * */
	public void addCourse(Course course){
		if (course != null)
			list.add(course);
	}
	
	/*
	 * Finds and return the course matching the specified prefix and number.
	 * 
	 * @param prefix the prefix of the target course
	 * @param number the number of the target course
	 * @return the course, or null if not found
	 * */
	public Course findCourse(String prefix, int number){
		/*first for-in*/
//		for(int i = 0; i < list.size(); i++){
//			Course course = list.get(i);
//			if( prefix.equals(course.getPrefix()) &&
//					number == course.getNumber()){
//				return course;
//			}
//		}
		for(Course course : list){
			if(prefix.equals(course.getPrefix()) &&
					number == course.getNumber()){
				return course;
			}
		}
		System.out.println("Course is not exist!");
		return null;
	}

	/*
	 *Adds the specified course after the target course.Does noting 
	 *edit course is null or if the target in not found 
	 *@param target the course after which the new course will be added
	 *@param newCourse the course to add 
	 * */
	public void addCourseAfter(Course target, Course newCourse){
		if(target == null || newCourse == null){
			return;
		}
		
		int targetIndex = list.indexOf(target);
		if(targetIndex != -1){
			list.add(targetIndex + 1, newCourse);
		}
	}
	
	/*
	 * Replace the specified target course with the new course.Does
	 * nothing if either course is null or if the target is not found
	 * @param target the course to be replaced
	 * @param newCourse the new Course to add
	 * */
	public void replace(Course target, Course newCourse){
		if(target == null || newCourse == null){
			return;
		}
		int targetIndex = list.indexOf(target);
		if (targetIndex != -1){
			list.add(targetIndex, newCourse);
		}
	}
	
	/*
	 * Create and return a string representation of this Program of study
	 * 
	 * @return a string representation of the program of Study
	 * */
	public String toString(){
		String result = "[";
		for(int i = 0; i < list.size(); i++){
			result += list.get(i);
			if(i < list.size() -1){
				result += "\n";
			}
		}
		result += "]";
		return result;
	}
	
	
	/*
	 * Returns an iterator for this Program of Study
	 * 
	 * @return an iterator for the Program of Study
	 * */
	@Override
	public Iterator<Course> iterator() {
		
		return list.iterator();
	}
	
	/*
	 * Saves a serialized version of this program of study to the specified
	 * file name;
	 * @param fileName the file name under which the POS will be stored
	 * @throws IOException
	 * */
	public void save(String fileName) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(this);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
	
	/*
	 * Loads a serialized program of study from the specified file.
	 * @param fileName the file from which the POS is read
	 * @return the loaded program of study;
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * */
	public static ProgramOfStudy load(String fileName)
			throws IOException, ClassNotFoundException{
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		ProgramOfStudy programOfStudy = (ProgramOfStudy) objectInputStream.readObject();
		objectInputStream.close();
		return programOfStudy;
	}
	
	

}

























