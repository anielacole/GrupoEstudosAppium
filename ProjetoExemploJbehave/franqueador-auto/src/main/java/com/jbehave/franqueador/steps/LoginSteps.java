package com.jbehave.franqueador.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jbehave.franqueador.pages.Login;
import com.jbehave.franqueador.pages.PageFactory;

public class LoginSteps {
	
	private Login login;
	
	 public LoginSteps(PageFactory pageFactory){
		 login = pageFactory.newLogin();
	    }
	 
	 @Given("I am on Franqueador App in context <context>")
	 public void openAplication(@Named("context") String context){
		 login.accessAplication(context);
	 }
	 
	 @When("I put the <username> and <password>")
	 public void setUsernamePassword(@Named("username") String username,@Named("password") String password){
		 login.setDataLogin(username, password);
	 }
	 
	 @When("I click on the button $buttonName")
	 public void access(@Named("buttonName") String buttonName){
		 login.access(buttonName);
	 }
	 
	 @Then("will display page Home")
	 public void verifyPageHome(){
		 login.verifyPageHome();
	 }

}
