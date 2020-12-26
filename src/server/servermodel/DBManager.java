package server.servermodel;

import java.util.ArrayList;

/**
 * This class is stimulating a database for our program.
 * @author nitishpradhan
 *
 */
public class DBManager {
	
	ArrayList <Course> courseList;
    MyJDBCApp jdbc;
	public DBManager () {
		courseList = new ArrayList<Course>();
		
	}

	
	public DBManager(MyJDBCApp jdbc)
	{
		this.jdbc=jdbc;


	}
	
	/**
	 * This function fills up courselist with courses to register for.
	 * @return, returns the list of courses 
	 */
	public ArrayList<Course> readFromDataBase() {
		// TODO Auto-generated method stub
		courseList.add(new Course ("ENGG", 233));
		//jdbc.insertCoursePreparedStatement(233, "ENGG");
		courseList.add(new Course ("ENSF", 409));
		//jdbc.insertCoursePreparedStatement(409, "ENSF");
		courseList.add(new Course ("PHYS", 259));
		//jdbc.insertCoursePreparedStatement(259, "PHYS");
		return courseList;
	}
	/**
	 * This function updates the information about the courses added in the data base of Mysql.
	 * @param jdbc, an object of MyJDBC that connects with the Mysql data base
	 */
	
	public void addCourseList(MyJDBCApp jdbc)
	{
		jdbc.insertCourseOfferingPreparedStatement(233, "ENGG");
		jdbc.insertCourseOfferingPreparedStatement(409, "ENSF");
		jdbc.insertCourseOfferingPreparedStatement(259, "PHYS");
	}
	
	
}
