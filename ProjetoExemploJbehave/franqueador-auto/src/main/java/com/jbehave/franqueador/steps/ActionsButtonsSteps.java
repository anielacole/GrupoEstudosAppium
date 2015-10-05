package com.jbehave.franqueador.steps;

import com.jbehave.franqueador.pages.ActionsButtons;
import com.jbehave.franqueador.pages.PageFactory;

public class ActionsButtonsSteps {
	
	ActionsButtons actionsButtons;
	
	public ActionsButtonsSteps(PageFactory pageFactory) {
		actionsButtons = pageFactory.newActionsButtons();
	}

//	 @When("I click on the button $buttonName")
//	 public void access(@Named("buttonName") String buttonName){
//		 actionsButtons.access(buttonName);
//	 }

}
