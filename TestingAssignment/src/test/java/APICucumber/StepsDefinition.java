package APICucumber;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import task.Runner.TaskRunner; 
public class StepsDefinition {		 
 
	String[] input=new String[5];
	 
	@Given("^I choose \"(.*?)\"$")
	public void i_choose(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		input[0]=arg1;
		System.out.println(input[0]);
	}

	@When("^I input \"(.*?)\"$")
	public void i_input(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		input[1]=arg1;
		System.out.println(input[1]);
	}

	@When("^I input$")
	public void i_input() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		input[1]=null;
		System.out.println(input[1]);
	}


	@When("^I search$")
	public void i_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		for(int i =1;i<input.length;i++)
//		{
//			System.out.println(input[i++]);
//		}
		TaskRunner.main(input);	 
	}

	@Then("^I should get High number of tweets\\((\\d+)\\)$")
	public void i_should_get_High_number_of_tweets(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("High number of tweets("+arg1+")",TaskRunner.output);
	}

	@Then("^I should get Low number of tweets\\((\\d+)\\)$")
	public void i_should_get_Low_number_of_tweets(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Low number of tweets("+arg1+")",TaskRunner.output);
	}

	@Then("^I should get false$")
	public void i_should_get_false() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(false,TaskRunner.conf);
	}

	@Then("^I should get WARNING$")
	public void i_should_get_WARNING() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals("WARNING",TaskRunner.output);
	}

	@Then("^I should get Invalid file$")
	public void i_should_get_Invalid_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Invalid file");
		Assert.assertEquals("Invalid file", TaskRunner.output);
	}
	
	@Then("^I should get true$")
	public void i_should_get_true() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions		
		Assert.assertEquals(true,TaskRunner.conf);
	}


}
