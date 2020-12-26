package server.servermodel;

import java.util.ArrayList;

/**
 * This class presents students with all the course that are up for registration.
 * @author nitishpradhan
 *
 */

public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		studentList  = new ArrayList <Student>();
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
	
	/**
	 * This function adds registration information about a student in the registered list.
	 * @param registration, the class where the registration info in stored
	 * @param t, the specific student that registered for a particular course
	 */
	public void addRegistration(Registration registration,Student t) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		studentList.add(t);
		
	}
	
	/**
	 * This function returns the number of student in the student list.
	 * @return, return the number of students
	 */
	public int studentNum() {
		return studentList.size();
	}
	

	
	

}

