package APICucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) // Framework to Run the tests

@CucumberOptions(features = "src/test/resources/features") // path to feature files
public class Tests {
	
}
