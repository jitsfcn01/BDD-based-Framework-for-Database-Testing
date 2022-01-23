package dbUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;





public class DatabaseConnection {
	
	public static Connection con = null;
	
	/**
	 * Method for creating DB Connection
	 * @author jitatmadison
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	public static Connection createConnection() throws FileNotFoundException, IOException{
		
		
		String userName="testuser1";
		String password="tuscany";
		String MySQLUrl="jdbc:mysql://35.239.76.158:3306/db_tuscany?user=testuser1";
	             
	         try {
	         con = DriverManager.getConnection(MySQLUrl, userName, password);
	       
	         if (con != null) {
	            System.out.println("******MySQL connection to db_tuscany database is successful******");
	          
	            
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	         
	         return con;
	   }


	/**
	 * Method for closing DB Connection
	 * @author jitatmadison
	 */
	public static void closeConnection(Connection con) throws SQLException
	{
		if (con != null)
		{
			con.close();
		}
	}
	
}


