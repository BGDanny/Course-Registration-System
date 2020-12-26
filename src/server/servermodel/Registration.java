package server.servermodel;

/**
 * This Class keeps tract of students that registered for specific course.
 * @author nitishpradhan
 *
 */
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		
		addRegistration (st);
	}
	
	
	/**
	 * This function updates the courses registered by a student in their own class and also in the class of course offering.
	 * @param st, the students the registered for a specific course
	 */
	public void addRegistration (Student st) {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this,st);
	}
	
	
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	

}