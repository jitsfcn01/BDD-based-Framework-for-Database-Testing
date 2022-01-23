package stepDefinition;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtility.CustomerLevel;
import dbUtility.OfficeByCountry;
import dbUtility.OrderStatusTotal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	
	CustomerLevel custlvl = new CustomerLevel();
	OrderStatusTotal ordrstatustot=new OrderStatusTotal();
	OfficeByCountry offbyCtry=new OfficeByCountry();
	CallableStatement cst = null;
	
	
	/*Step definitions of GetCustomerLevel Scenario */
	
	@Given("A database with stored procedures GetCustomerLevel")
	public void a_database_with_stored_procedures_get_customer_level() throws FileNotFoundException, IOException {
		custlvl.getConnection();
	}
	@When("Making a request against a stored procedures GetCustomerLevel")
	public void making_a_request_against_a_stored_procedures_get_customer_level() {
		cst=custlvl.callToStoredProcedure();
	}
	@Then("I will get data back from GetCustomerLevel")
	public void i_will_get_data_back_from_get_customer_level() throws SQLException {
		String retrieveData=custlvl.retriveResultSetFromStoredProcedure(cst);
	    System.out.println(retrieveData);
	    
	}
	
	/*Step definitions of GetOrderCountByStatus Scenario */
	
	@Given("A database with stored procedures GetOrderCountByStatus")
	public void a_database_with_stored_procedures_get_order_count_by_status() throws FileNotFoundException, IOException {
	    
		ordrstatustot.getConnection();
	}

	@When("Making a request against a stored procedures GetOrderCountByStatus")
	public void making_a_request_against_a_stored_procedures_get_order_count_by_status() {
	    
	    cst=ordrstatustot.callToStoredProcedure();
	}

	@Then("I will get data back data from stored procedure GetOrderCountByStatus")
	public void i_will_get_data_back_data_from_stored_procedure_get_order_count_by_status() throws SQLException {
	    
		Integer retrieveData=ordrstatustot.retriveResultSetFromStoredProcedure(cst);
	    System.out.println(retrieveData);
	    
	}
	
	
	/*Step definitions of GetOfficeByCountry Scenario */

	@Given("A database with stored procedures GetOfficeByCountry")
	public void a_database_with_stored_procedures_get_office_by_country() throws FileNotFoundException, IOException {
		offbyCtry.getConnection();
	    
	}

	@When("Making a request against a stored procedures GetOfficeByCountry")
	public void making_a_request_against_a_stored_procedures_get_office_by_country() {
	    
		
		cst=offbyCtry.callToStoredProcedure();
		
	}

	@Then("I will get data back data from stored procedure GetOfficeByCountry")
	public ResultSet i_will_get_data_back_data_from_stored_procedure_get_office_by_country() throws SQLException {
		ResultSet rs=null;
		if(cst!=null)
	    {
		rs=offbyCtry.retriveResultSetFromStoredProcedure(cst);
	    
	    System.out.println(rs);
	    }
	    return rs;
	    
	}
	
}