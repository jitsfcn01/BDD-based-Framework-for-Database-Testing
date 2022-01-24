package dbUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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


public class DatabaseConnection implements DbDetails {
	
	public static Connection con = null;
	
	 /**
		 * Method for creating DB Connection
		 * @author jitatmadison
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
	
	public static Connection createConnection() throws FileNotFoundException, IOException{
		
		DbDetails dbdtls=new DatabaseConnection();
		
		try {
	         con = DriverManager.getConnection(dbdtls.MYSQLURL, dbdtls.DBUSERNAME, dbdtls.DBPASSWORD);
	       
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


