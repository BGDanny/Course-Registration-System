package server.servermodel;

import java.util.ArrayList;


/**
 * This class defines all the necessary attributes of a student who is trying to register for a course.
 * @author nitishpradhan
 *
 */
public class Student {

	private String studentName;
	private int studentId;
	// private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;

	public ArrayList<Registration> getStudentRegList() {
		return studentRegList;
	}

	public Student(String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		String st = "Student Name: " + getStudentName() + "\n" + "Student Id: " + getStudentId() + "\n\n";
		return st;
	}
	/**
	 * This function adds the registration information about a specific student the registration list.
	 * @param registration, the registration information to be added.
	 */
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}
	
	/**
	 * This function makes sure that a student does not exceeds the registration limit.
	 * @return, returns ture or false based on the boolean check of limit crossed
	 */
	public boolean courseLimit() {
		if (this.studentRegList.size() > 6)
			return false;
		return true;
	}
	
	/**
	 * This function deletes the last course present in the registration list of a particular student.
	 */
	

	public void deleteLastCourse() {
		studentRegList.remove(studentRegList.size() - 1);		
	}

}
