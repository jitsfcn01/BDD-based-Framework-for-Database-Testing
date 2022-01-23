Feature: Fetching data from Stored procedure
 
Scenario: Retrieve data from Stored Procedure GetCustomerLevel
    Given A database with stored procedures GetCustomerLevel
    When Making a request against a stored procedures GetCustomerLevel
    Then I will get data back from GetCustomerLevel
    
    
Scenario: Retrieve data from Stored Procedure GetOrderCountByStatus
    Given A database with stored procedures GetOrderCountByStatus
    When Making a request against a stored procedures GetOrderCountByStatus
    Then I will get data back data from stored procedure GetOrderCountByStatus
    
Scenario: Retrieve data from Stored Procedure GetOfficeByCountry
    Given A database with stored procedures GetOfficeByCountry
    When Making a request against a stored procedures GetOfficeByCountry
    Then I will get data back data from stored procedure GetOfficeByCountry
    

    
    
    
    
    

  
