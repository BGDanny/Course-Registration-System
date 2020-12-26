package server.servermodel;
/**
 * interface having details of connecting with the mysql database 
 * @author kameshwara sekar
 *
 */
public interface IDBCredentials {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/courseregistrationsystem";   //I created in my database

	   //  Database credentials
	   static final String USERNAME = "root";
	   static final String PASSWORD = "sKameshwara4221";

}
