package server.servercontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import server.servermodel.Course;
import server.servermodel.CourseCatalogue;
import server.servermodel.MyJDBCApp;
import server.servermodel.Registration;
import server.servermodel.Student;

/**
 * This class holds holds object of an socket used by a client to communicate with server, and performs all the necessary communication with client.
 * @author kameshwara sekar
 *
 */
public class multiClients implements Runnable {

	String name;
	int num;
	private Socket asocket;
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	CourseCatalogue courseCat;
	MyJDBCApp jdbc;
	public multiClients(Socket aSocket,  BufferedReader socketInput,PrintWriter socketOutput, CourseCatalogue courseCat,MyJDBCApp jdbc ) {
		this.asocket= aSocket;
		this.socketInput= socketInput;
		this.socketOutput= socketOutput;
		this.courseCat = courseCat;
		this.jdbc=jdbc;
	}
	
	/**
	 * This function is to communicate the the client and from the response they provide send an appropriate response.
	 * It uses a switch command to send the required response.
	 */
	public void run() {
		
		StringBuffer bufferedReader = null;
		//jdbc.createCourseTable("COURSE");
		while(true) {
			
			try {
				bufferedReader = new StringBuffer(socketInput.readLine());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			String line = bufferedReader.toString();
			
			String word[] = line.split("\\s+");
			
			int input =  Integer.parseInt(word[0]);
			//if(word[3]!=null && word[4]!=null)
//			{
//			name=word[3];
//			num=Integer.parseInt(word[4]);
//			}
//			int i=0;
//			if(i==0)
//			{
//				addStudent();
//				i++;
//			}
			if(input==6) {
				System.out.println("Thank you");
				try
				{
					this.asocket.close();
					
				}catch(IOException e)
				{
					e.printStackTrace();
					
				}
				break;
			}
				
			switch(input) {
			
			case 1:
				//System.out.println(word[0]);
				searchCourse(word[1], Integer.parseInt(word[2]),courseCat);
				break;
				
			case 2:
				try {
					register(word[1],Integer.parseInt(word[2]),word[3],Integer.parseInt(word[4]),courseCat);
					addCourse(word[1], Integer.parseInt(word[2]),courseCat,jdbc);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				removeCourse(word[1], Integer.parseInt(word[2]),courseCat,jdbc);
				break;
				
			case 4:
				socketOutput.println(courseCat.toString().trim().replaceAll("[\n]{1,}", "&") );
				break;
				
			case 5:
				
				socketOutput.println(courseCat.displayStudentCourse());
				break;
				

				
			default:
				System.out.println("Invalid input. Please Try Again");
				break;
				}
		
		}

	}
	
	/**
	 * This function removes the course from the list of courses in the course catalouge.
	 * @param name, the name of the course
	 * @param num, the number id of the course
	 * @param courseCat, the course catalouge from where the course should removed
	 * @param jdbc, a connecter to the data base of Mysql
	 */
	private synchronized void removeCourse(String name, int num, CourseCatalogue courseCat,MyJDBCApp jdbc) {
		
		courseCat.removeCourse(name, num);
		socketOutput.println("Remove course successful");
		jdbc.deleteCoursePreparedStatement(num, name);
	
	}
	
	/**
	 * This function adds a course to the course catalouge.
	 * @param name, the name of the course
	 * @param num, the id of the course
	 * @param courseCat, tthe course catalouge from where the course should added
	 * @param jdbc,a connecter to the data base of Mysql
	 * @throws SQLException
	 */

	private synchronized void addCourse(String name, int num,CourseCatalogue courseCat,MyJDBCApp jdbc) throws SQLException {
		courseCat.addCourse(name, num);
		socketOutput.println("Add course successful");
		jdbc.insertCoursePreparedStatement(num, name);
		
		}
	/**
	 *This function searches a course in the course catalouge.
	 * @param name, the name of the course
	 * @param num, the id of the course
	 * @param courseCat, the course catalouge where the course is searched
	 */

	private synchronized void searchCourse(String name, int num,CourseCatalogue courseCat) {
		
		Course temp = courseCat.searchCat(name, num);
		if (temp != null)
			socketOutput.println(temp.getCourseName() + " " + temp.getCourseNum() + " is found.");

		
		}
	
	private void register(String name, int id,String nameS, int IDS,CourseCatalogue courseCat) {
		Student st = new Student(nameS,IDS);
		Course myCourse = courseCat.searchCat(name,id);
		if (myCourse != null) {
			courseCat.createCourseOffering(myCourse, 1, 400);
			courseCat.createCourseOffering(myCourse, 2, 300);
		}
		Registration engg233 = new Registration();
		engg233.completeRegistration(st, myCourse.getCourseOfferingAt(0));
	}

	public void addStudent()
	{
		jdbc.insertStudentPreparedStatement( num,name);
	}


}
