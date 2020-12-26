package server.servermodel;

import java.util.ArrayList;


	/**
	* This class includes a list that hass all the courses that are up to be registered.
	* @author nitishpradhan
	*
	*/
	public class CourseCatalogue {

	private ArrayList<Course> courseList;

	public CourseCatalogue() {
		loadFromDataBase();
	}
	
	/**
	 * This Function fills up the course list by the appropriate courses.
	 */
	private void loadFromDataBase() {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());

	}
	
	/**
	 * This function creates a list of course offering that are up to be registered.
	 * @param c, the course to be offered
	 * @param secNum, the section id to be placed in
	 * @param secCapm the section Cap to be place in
	 */
	public void createCourseOffering(Course c, int secNum, int secCap) {
		if (c != null) {
			CourseOffering theOffering = new CourseOffering(secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	/**
	 * This function searches for a course in the course catalouge.
	 * @param courseName, the name of the course
	 * @param courseNum, the number id of the course
	 * @return, returns the course or if not found returns null
	 */
	public Course searchCat(String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) && courseNum == c.getCourseNum()) {
				return c;
			}
		}
		displayCourseNotFoundError();
		return null;
	}

	/**
	 * This function displays an appropriate message if the searched course was not found.
	 */
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");

	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c; // This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}
	
	/**
	 * This function adds a course in the course list.
	 * @param namem the name of the course
	 * @param Num, the id of the course
	 */
	public void addCourse(String name, int Num) {
		Course temp = new Course(name, Num);
		courseList.add(temp);
	}

	/**
	 * This function removes the course from the course list.
	 * @param name, the name of the course
	 * @param Numm the number id of the course
	 */
	public void removeCourse(String name, int Num) {

		for (int i = 0; i < courseList.size(); i++) {
			if (name.equals(courseList.get(i).getCourseName()) && Num == courseList.get(i).getCourseNum())
				courseList.remove(i);
	
		}
	}
	/**
	 * Displays all the courses present in the course list.
	 * @return, returns the list of all courses as a String object
	 */
	public String displayStudentCourse() {
		String st="Students have taken the following courses: &";
		for(int i=0;i<courseList.size();i++) {
			if(courseList.get(i).checkStudent())
				st+=courseList.get(i).getCourseName()+" "+courseList.get(i).getCourseNum()+"&";
		}
		return st;
		
	}

}
