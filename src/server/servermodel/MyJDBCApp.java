
package server.servermodel;

import java.sql.*;

/**
 * CLASS MyJDBCApp implementing IDBCredentials
 * @author kameshwara sekar
 *
 */
public class MyJDBCApp implements IDBCredentials {

	private Connection myConn;
	private Statement stmt;
	private ResultSet rs;
	
	/**
	 * the class to initialize the connection between the mysql database and 
	 * java program
	 */
	public void initializeConnection()          //you have to make changes to it
	{
		try{
			
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			// Open a connection
			myConn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			}
		catch(SQLException e) {
			e.printStackTrace();
			}
		}
	
	/**
	 * method to close all the connections
	 */
	public void close() 
	{
		try{
			stmt.close();
			rs.close();
			myConn.close();
			}
		catch(SQLException e) 
		{
				e.printStackTrace();
		}
	}
		
	/**
	 * prepared statement method for inserting a student 
	 * into the student table
	 * @param studentNum-student number
	 * @param studentName-student name
	 */
	
	public void insertStudentPreparedStatement(int studentNum,String studentName)
	{
		try {
			String query="INSERT INTO courseregistrationsystem.student(student_num,student_name) values (?,?)";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1, studentNum);
			ps.setString(2, studentName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * prepared statement method for inserting a course
	 * into the course table
	 * @param courseNum-course number
	 * @param courseName-course name
	 */
	public void insertCoursePreparedStatement(int courseNum,String courseName) 
	{
		try {
			String query="INSERT INTO courseregistrationsystem.course(course_num,course_name) values (?,?)";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1,courseNum);
			ps.setString(2, courseName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}

		
	}
	/**
	 * prepared statement method for deleting a course
	 * into the course table
	 * @param courseNum-course number
	 * @param courseName-course name
	 */
	public void deleteCoursePreparedStatement(int courseNum,String courseName)
	{
		try {
			String query="DELETE from courseregistrationsystem.course where course_num=?";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1,courseNum);
		//ps.setString(2, courseName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * prepared statement method for deleting a student
	 * from table student
	 * @param studentNum-student number
	 * @param studentName-student name
	 */
	
	public void deleteStudentPreparedStatement(int studentNum,String studentName)
	{
		try {
			String query="DELETE from courseregistrationsystem.student where student_num =? ";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1,studentNum);
			ps.setString(2, studentName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * prepared statement method for deleting a course 
	 * in courseoffering
	 * @param courseNum-course number
	 * @param courseName-course name
	 */
	
	public void deleteCourseOfferingPreparedStatement(int courseNum,String courseName)
	{
		try {
			String query="DELETE from courseregistrationsystem.courseoffering where course_num=?";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1,courseNum);
		//ps.setString(2, courseName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
	/**
	 * prepared statement method for inserting a course 
	 * in courseoffering
	 * @param courseNum-course number
	 * @param courseName-course name
	 */
	
	public void insertCourseOfferingPreparedStatement(int courseNum,String courseName) 
	{
		try {
			String query="INSERT INTO courseregistrationsystem.courseoffering(course_num,course_name) values (?,?)";
			PreparedStatement ps=myConn.prepareStatement(query);
			ps.setInt(1,courseNum);
			ps.setString(2, courseName);
			int rowCount=ps.executeUpdate();
			System.out.println("row count="+rowCount);
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}

		
	}
	
	
	/**
	 * method to create table course
	 * @param s-table name
	 */
	
	public void createCourseTable(String s) {
		String sql = "CREATE TABLE COURSE(course_num INTEGER not NULL, " + " course_name VARCHAR(255), "
				 + " PRIMARY KEY ( course_num))";

		try {
			Statement stmt = myConn.createStatement(); // construct a statement
			stmt.executeUpdate(sql); // execute my query (i.e. sql)
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Table can NOT be created!");
		}
		System.out.println("Created table in given database...");
	}
	
	/**
	 * method to create table student
	 */
	public void createStudentTable() {
		String sql = "CREATE TABLE STUDENT " + "(student_num INTEGER not NULL, " + " student_name VARCHAR(255), "
				 + " PRIMARY KEY ( student_num))";

		try {
			Statement stmt = myConn.createStatement(); // construct a statement
			stmt.executeUpdate(sql); // execute my query (i.e. sql)
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Table can NOT be created!");
		}
		System.out.println("Created table in given database...");
	}
	/**
	 * method to create table courseoffering
	 */
	public void createCourseOfferingTable() {
		String sql = "CREATE TABLE COURSEOFFERING (course_num INTEGER not NULL, " + " course_name VARCHAR(255)," 
				 + " PRIMARY KEY ( course_num))";

		try {
			Statement stmt = myConn.createStatement(); // construct a statement
			stmt.executeUpdate(sql); // execute my query (i.e. sql)
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Table can NOT be created!");
		}
		System.out.println("Created table in given database...");
	}
	
	
	
	
}
