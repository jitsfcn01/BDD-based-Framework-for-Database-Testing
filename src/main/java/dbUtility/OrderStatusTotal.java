package dbUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Types;



public class OrderStatusTotal {
	
Connection con = null;
	
/**
 * Method for getting Connected to DB
 * @author jitatmadison
 * @throws IOException ,FileNotFoundException
 * @throws FileNotFoundException 
 */
	public void getConnection() throws FileNotFoundException, IOException
	{
		con=DatabaseConnection.createConnection();
	}
	
	/**
	 * Method for requesting call to Stored Procedure GetOrderCountByStatus
	 * @author jitatmadison
	 */
	
	public CallableStatement callToStoredProcedure()
	{
		CallableStatement cst=null;
		
		try
		{
			String theOrderStatus="Shipped";
			if (con != null) {
	            
	            cst = con.prepareCall("{call GetOrderCountByStatus(?, ?)}");
	            
	            //Set the Parameters
	            cst.setString(1, theOrderStatus);
	            cst.registerOutParameter(2, Types.INTEGER);
	            
	            //Calling the stored procedure
	            System.out.println("Calling stored procedure. GetOrderCountByStatus('" +theOrderStatus+"',?)");
	            cst.execute();
			
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cst;
	}
	
	/**
	 * Method for getting back data from Stored Procedure GetOrderCountByStatus
	 * @author jitatmadison
	 */
	public Integer retriveResultSetFromStoredProcedure(CallableStatement cst) throws SQLException
	{
		//Get the value of OUT Parameter
		int theCount=cst.getInt(2);
        
        System.out.println("Count of Orders in Shipped status  :" +theCount);
        if (con!=null)
        {
        	DatabaseConnection.closeConnection(con);
        }
        return theCount;
	}
}


