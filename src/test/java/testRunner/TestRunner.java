package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		  features ="src/test/resources/FeatureFiles/RetrieveDataFromStoredProcedure.feature",
		  glue ={"stepDefinition"},
		  monochrome=true 
		  
		  
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
