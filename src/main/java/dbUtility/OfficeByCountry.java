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


public class OfficeByCountry {

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
	 * Method for requesting call to Stored Procedure GetOfficeByCountry
	 * @author jitatmadison
	 */
	
	public CallableStatement callToStoredProcedure()
	{
		CallableStatement cst=null;
		try
		{
			String theCountry="USA";
			cst = con.prepareCall("{call GetOfficeByCountry(?)}");
            
            //Set the Parameters
            cst.setString(1, theCountry);
            
            
            //Calling the stored procedure
            System.out.println("Calling stored procedure. GetOfficeByCountry('" +theCountry+"')");
            cst.execute();
            
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cst;
	}
	
	/**
	 * Method for getting back data from Stored Procedure GetOfficeByCountry
	 * @author jitatmadison
	 */
	public ResultSet retriveResultSetFromStoredProcedure(CallableStatement cst) throws SQLException
	{
		ResultSet rs = cst.getResultSet();
        System.out.println("Retrieve the result from GetOfficeByCountry where Country is USA");
        System.out.println("=================================================================");
        
        while(rs.next())
        {
        	System.out.println("officeCode  :" +rs.getString(1));
        	System.out.println("city  :" +rs.getString(2));
        	System.out.println("phone  :" +rs.getString(3));
        	System.out.println("addressLine1  :" +rs.getString(4));
        	System.out.println("addressLine2  :" +rs.getString(5));
        	System.out.println("state  :" +rs.getString(6));
        	System.out.println("country  :" +rs.getString(7));
        	System.out.println("postalCode  :" +rs.getString(8));
        	System.out.println("territory  :" +rs.getString(9));
        	System.out.println();
         }
        if (con!=null)
        {
        	DatabaseConnection.closeConnection(con);
        }
        return rs;
	}
	
}
