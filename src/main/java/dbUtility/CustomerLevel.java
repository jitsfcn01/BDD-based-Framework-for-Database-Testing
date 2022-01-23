package dbUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Types;

public class CustomerLevel {

	Connection con = null;
	
	/**
	 * Method for getting Connected to DB
	 * @author jitatmadison
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void getConnection() throws FileNotFoundException, IOException
	{
		con=DatabaseConnection.createConnection();
	}
	
	/**
	 * Method for requesting call to Stored Procedure GetCustomerLevel
	 * @author jitatmadison
	 */
	public CallableStatement callToStoredProcedure()
	{
		ResultSet rs=null;
		CallableStatement cst=null;
	     		   
        try {
        
        
        Integer custNumber=141;
        if (con != null) {
           	            
           cst = con.prepareCall("{call GetCustomerLevel(?,?)}");
           
           //Set the Parameters
           cst.setInt(1,custNumber);
           cst.registerOutParameter(2, Types.VARCHAR);
           
           //Calling the stored procedure
           System.out.println("Calling stored procedure. GetCustomerLevel('" +custNumber+"',?)");
           cst.execute();
           
        }
     } catch (Exception e) {
        e.printStackTrace();
     }
        
        return cst;
	}
	
	/**
	 * Method for getting result set from stored procedure GetCustomerLevel
	 * @author jitatmadison
	 */
	public String retriveResultSetFromStoredProcedure(CallableStatement cst) throws SQLException
	{
		//Get the value of OUT Parameter
        String level=cst.getString(2);
        
        System.out.println("CustomerLevel :" +level);
        if (con!=null)
        {
        	DatabaseConnection.closeConnection(con);
        }
        return level;
	}

}
