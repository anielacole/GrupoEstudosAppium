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
	
	private final String ERROR_MESSAGE = "ERRO: n�o foi poss�vel executar o teste.";
	
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
	
	@Then("I'm at the Sinesp app home")
	@Given("I'm at the Sinesp app home")
	public void imAtSinespHome() {
		Assert.assertTrue(android.getNumeroBotoesHome() > 0);
	}
	
	@When ("I click in the Veiculos button")
	public void clickVeiculoButton () {
		android.clickVeiculoButton();
	}
	
	@Then ("I see there are $amount buttons")	
	public void validatenothing(@Named("amount") int howManyButtons) {		
		Assert.assertEquals(howManyButtons, android.getNumeroBotoesHome());
	}
	
	
	
	
	
	
	
//	Given I'm at the Sinesp app home
//	When I click in the Ve�culos button
//	Then I see the button "checar situa��o"
//	When I type the plate "icq5550"
//	Then the editText1 field will contain "icq"
//	And the editText2 field will contain "5550"
//	When I click in the checar situa��o button
//	Then I see the message "placa n�o foi encontrada"
	
}

