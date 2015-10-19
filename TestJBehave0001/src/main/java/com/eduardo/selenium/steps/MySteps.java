package com.eduardo.selenium.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.eduardo.android.device.AndroidTasks;

public class MySteps {
    
	@Given("I have set up the device")
	public void deviceSetup() {
		
	}
	
	@When ("I fire the application $app")	
	public void fireApp(@Named("app") String appName) {
		AndroidTasks.fireDevice();
	}
	
	@Then ("I see nothing really happens")
	public void validatenothing() {
		
	}
	
}


/**
	Given I have set up the device
	When I fire the application Triangulo
	Then I see nothing really happens
  
 */