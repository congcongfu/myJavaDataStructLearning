package test;

import java.io.IOException;

import model.Course;
import model.ProgramOfStudy;

public class PostTester {

	public static void main(String[] args) throws IOException {
		
		ProgramOfStudy programOfStudy = new ProgramOfStudy();
		programOfStudy.addCourse(new Course("PE", 101, "Introduction to Programming", "A-"));
		programOfStudy.addCourse(new Course("English", 222, "Grade six"));
		programOfStudy.addCourse(new Course("CS", 210, "Computer Architecture"));
		programOfStudy.addCourse(new Course("GER", 320, "Intermediate German"));
		programOfStudy.addCourse(new Course("THE", 201, "The Theatre Experience"));
		
		Course arch = programOfStudy.findCourse("CS", 210);
		if(arch != null){
			programOfStudy.addCourseAfter(arch, new Course("CS", 321, "Operation Systems"));

		}

		Course theatre = programOfStudy.findCourse("THE", 201);
		if(theatre != null){
			theatre.setGrade("A");
		}
		
//		
		Course german = programOfStudy.findCourse("GER", 320);
		if(german != null){
			german.setGrade("C");
			programOfStudy.replace(german, new Course("FRE", 110, "Beginning French", "B+"));
		}
		
		
		System.out.println(programOfStudy.toString());
		programOfStudy.save("programOfStudy");
	}

}
