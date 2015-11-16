package com.eduardo.selenium.steps;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.eduardo.android.device.AndroidDevice;



public class MySteps {
	
	private final String ERROR_MESSAGE = "ERRO: não foi possível executar o teste.";
	
	private AndroidDevice android;
    
	@Given("I have set up the device")
	
	public void deviceSetup() {	
		
		android = new AndroidDevice();	
	}
	
	@When ("I Fire up the app")
	
	public void fireApp() {		
		
		// Executar comandos android		
		try {			
			
			android.runTest();		
		}
		catch (ExecuteException e) {
			
			System.out.println(ERROR_MESSAGE);
			e.printStackTrace();			
		} 
		catch (IOException e) {
			System.out.println(ERROR_MESSAGE);
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			System.out.println(ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	@Then ("I see there are $amount buttons")
	
	public void validatenothing(@Named("amount") int howManyButtons) {		
		Assert.assertEquals(android.getResultMessage(), howManyButtons);			
	}
	
}

