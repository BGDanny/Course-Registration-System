//kameshwara sekar

//junhao xue
//nitish pradhan

package server.servercontroller;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import server.servermodel.*;
/**
 * server communication call
 * @author kameshwara sekar
 *
 */
public class ServerCommunication {
	
	
	//private CourseCatalogue courseCat;
	private Course course;
	private Registration register;
	 
	
	
		/**
		 * The server socket
		 */
	private ServerSocket serverSocket;
		/**
		 * The socket of an client
		 */
	

		/**
		 * Construct a Server with Port 9090
		 */
	
	private ExecutorService pool;
	/**
	 * constructor of servercommunication
	 */
	public ServerCommunication() {
			try {
				serverSocket = new ServerSocket(9091);
				pool = Executors.newCachedThreadPool();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * the communicate method to connect with the client
		 * @param courseCat-courseCatelouge
		 * @param jdbc-the object of MyJDBCApp
		 * @throws IOException
		 */
	public void Communicate(CourseCatalogue courseCat,MyJDBCApp jdbc) throws IOException {
		
		
			while(true) {
		
		
		
		 Socket aSocket = serverSocket.accept();
		 System.out.println(" a client has connected");
		 
		 BufferedReader socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		 PrintWriter socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
		
		multiClients Client = new multiClients(aSocket,socketInput, socketOutput,courseCat,jdbc);
		pool.execute(Client);
		
		
			}
		
	}





    public static void main(String[] args) throws IOException {
		ServerCommunication sc = new ServerCommunication();
		CourseCatalogue courseCat = new CourseCatalogue();
		MyJDBCApp jdbc=new MyJDBCApp();
		
        jdbc.initializeConnection();
        jdbc.createCourseOfferingTable();
        jdbc.createCourseTable("COURSE");    //taking time to create but creates
        //jdbc.createStudentTable();

        DBManager db=new DBManager();

        db.addCourseList(jdbc);
       
       
		sc.Communicate(courseCat,jdbc);
	}
	
	
	

}
